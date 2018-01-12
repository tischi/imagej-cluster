package de.embl.cba.cluster;

import java.util.concurrent.*;

public class ClusterRunnableFuture implements RunnableFuture
{
    SlurmExecutorService slurmExecutorService;
    ClusterRunnable clusterRunnable;

    public ClusterRunnableFuture( ClusterRunnable clusterRunnable, SlurmExecutorService slurmExecutorService )
    {
        this.clusterRunnable = clusterRunnable;
        this.slurmExecutorService = slurmExecutorService;
    }

    public boolean cancel( boolean mayInterruptIfRunning )
    {
        return false;
    }

    public boolean isCancelled()
    {
        return false;
    }

    public boolean isDone()
    {
        slurmExecutorService.checkJobStatus( clusterRunnable.jobID );
        return false;
    }

    public Object get() throws InterruptedException, ExecutionException
    {
        return null;
    }

    public Object get( long timeout, TimeUnit unit ) throws InterruptedException, ExecutionException, TimeoutException
    {
        return null;
    }

    public void run()
    {
        clusterRunnable.run();
    }
}
