package org.francis.springbootspringbatch.config.listenerDemo;

import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.item.Chunk;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
public class MyChunkListener{
    @BeforeChunk
    public void beforeChunk(ChunkContext chunkContext){
        System.out.println(chunkContext.getStepContext().getStepName()+" chunk before running...");
    }
    @AfterChunk
    public void afterChunk(ChunkContext chunkContext){
        System.out.println(chunkContext.getStepContext().getStepName()+" chunk after running...");
    }
}
