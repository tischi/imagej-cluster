package de.embl.cba.cluster.job;

import de.embl.cba.cluster.SlurmExecutorService;

public class ImageJCommandSlurmJob implements SlurmJob
{

    public static final String ALMF_CLUSTER_IMAGEJ_CMD = "/g/almf/software/Fiji.app/ImageJ-linux64 --ij2 --headless --run";
    public static final String CBA_CLUSTER_IMAGEJ_CMD = "/g/cba/software/Fiji.app/ImageJ-linux64 --ij2 --headless --run";

    private String commandAndParameters;

    public ImageJCommandSlurmJob( String commandAndParameters)
    {
        this.commandAndParameters = commandAndParameters;
    }

    @Override
    public String getJobText( SlurmExecutorService slurmExecutorService )
    {
        SlurmJobScript slurmJobScript = new SlurmJobScript();

        slurmJobScript.addExecutableCommand( "module load Java" );
        slurmJobScript.addExecutableCommand( "module load X11" );
        slurmJobScript.addExecutableCommand( commandAndParameters );

        return slurmJobScript.jobText( slurmExecutorService );

    }


}
