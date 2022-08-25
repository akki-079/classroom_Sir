package com.demo.executors.ex1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.demo.threads.sync.TableGenerator;
import com.demo.threads.sync.TableWorker;

public class ExecutorDemo1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service= Executors.newFixedThreadPool(3);
		
		TableGenerator tableGenerator=new TableGenerator();
		
		Future<?>  future1=service.submit(new TableWorker(tableGenerator, 8));
		Future<?>  future2=service.submit(new TableWorker(tableGenerator, 4));
		Future<?>  future3=service.submit(new TableWorker(tableGenerator, 5));
		
		System.out.println(future1.get());
		System.out.println("Hi..");
		service.shutdown();

	}

}
