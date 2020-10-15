package test.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;

public class MainRedis {

	// Lettuce
		static public RedisClient redisClient;
		static public RedisAsyncCommands<String, String> asyncCommands = null;
		static public StatefulRedisConnection<String, String> redisConnection;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// TODO Auto-generated method stub
				RedisURI redisUri = RedisURI.Builder.redis("192.168.153.142", 6379)
						.withPassword("r@!nDr0p$Ke3pFall!nonM773@dB!t@rA$8!r!n3haha")
						// .withDatabase(2)
						.build();

				redisClient = RedisClient.create(redisUri);
				redisConnection = redisClient.connect();
				if (redisConnection != null) {
					asyncCommands = redisConnection.async();
					System.out.println("connection success");
					
					//asyncCommands.rpush("clevland", "102");
					
					String out = null;
					
					RedisFuture<List<String>> output = asyncCommands.lrange("clevland", 0, 0);
					
					try {
						
						out = output.get().toString().substring(1, output.get().toString().length() - 1);
						
						//Arrays.toString(output.get());list.toString().substring(1, list.toString().length() - 1);
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(" the retrieved value is:"+ out);
					System.out.println(" --- COMPLETED --- ");
				
				} else {
					
					System.out.println("connection failed");
					
				}
		
		
		
	}

}
