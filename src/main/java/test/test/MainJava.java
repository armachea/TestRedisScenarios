package test.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.masterslave.StatefulRedisMasterSlaveConnection;
import io.lettuce.core.protocol.RedisCommand;


public class MainJava {

	// Lettuce
	static public RedisClient redisClient;
	static public RedisAsyncCommands<String, String> asyncCommands = null;
	static public StatefulRedisConnection<String, String> redisConnection;

	public static List<String> listofWordsCUSTOM = new ArrayList<String>();
	public static List<String> listofWordsCUSTOMALL = new ArrayList<String>();
	public static List<String> listofWordsCUSTOMSENDERGT = new ArrayList<String>();
	public static List<String> listofWordsCUSTOMGTMESSAGE = new ArrayList<String>();
	// public static List<String> listofWordsCUSTOMNETWORKSENDER = new
	// ArrayList<String>();

	public static List<String> listofWordsSMSGTRANGEBLACK = new ArrayList<String>();
	public static List<String> listofWordsSMSGTRANGEWHITE = new ArrayList<String>();
	public static List<String> listofWordsALLGTS = new ArrayList<String>();
	public static List<String> listofWordsBLACKLISTGTS = new ArrayList<String>();
	public static List<String> listofWordsWHITELISTGTS = new ArrayList<String>();

	static String sender = "";
	static String msg = "mommy";
	static String remoteGT = "121212";
	
	static String localAddressGT = "";
	static String remoteAddressGT = "249";
	

	public static void main(String[] args) {
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

			// CUSTOM RULE
			RedisFuture<Long> existKeyCustom = asyncCommands.exists("custom");
			RedisFuture<Long> existKeyCustomAll = asyncCommands.exists("customAll");
			RedisFuture<Long> existKeyCustomSenderGt = asyncCommands.exists("customSenderGt");
			RedisFuture<Long> existKeyCustomGtMessage = asyncCommands.exists("customGtMessage");

			// GTS RULE
			RedisFuture<Long> existKeyBlacklistedGT = asyncCommands.exists("blacklistGts");
			RedisFuture<Long> existKeyWhitelistedGT = asyncCommands.exists("whitelistGts");
			RedisFuture<Long> existKeyBlackGTRange = asyncCommands.exists("gtsRange");
			RedisFuture<Long> existKeyWhiteGTRange = asyncCommands.exists("whitegtsRange");

			try {

				///// CUSTOM RULE //////////////
				
//				if (existKeyCustomAll.get().toString().equals("1")) {
//					System.out.println(" the key exist check CustomAll");
//					// Check existKeySmsContent Exist
//					RedisFuture<List<String>> valuesCUSTOMALL = asyncCommands.zrange("customAll", 0, -1);
//					if (!valuesCUSTOMALL.get().isEmpty()) {
//						listofWordsCUSTOMALL = valuesCUSTOMALL.get();
//						System.out.println(listofWordsCUSTOMALL);
//					}
//				}
//
//				if (existKeyCustom.get().toString().equals("1")) {
//					System.out.println(" the key exist check Custom");
//					// Check existKeySmsContent Exist
//					RedisFuture<List<String>> valuesCUSTOM = asyncCommands.zrange("custom", 0, -1);
//					if (!valuesCUSTOM.get().isEmpty()) {
//						listofWordsCUSTOM = valuesCUSTOM.get();
//						System.out.println(listofWordsCUSTOM);
//					}
//				}
//
//				if (existKeyCustomSenderGt.get().toString().equals("1")) {
//					System.out.println(" the key exist check CustomSenderGt");
//					// Check existKeySmsContent Exist
//					RedisFuture<List<String>> valuesCUSTOMSENDERGT = asyncCommands.zrange("customSenderGt", 0, -1);
//					if (!valuesCUSTOMSENDERGT.get().isEmpty()) {
//						listofWordsCUSTOMSENDERGT = valuesCUSTOMSENDERGT.get();
//						System.out.println(listofWordsCUSTOMSENDERGT);
//					}
//				}
//
//				if (existKeyCustomGtMessage.get().toString().equals("1")) {
//					System.out.println(" the key exist check CustomGtMessage");
//					// Check existKeySmsContent Exist
//					RedisFuture<List<String>> valuesCUSTOMGTMESSAGE = asyncCommands.zrange("customGtMessage", 0, -1);
//					if (!valuesCUSTOMGTMESSAGE.get().isEmpty()) {
//						listofWordsCUSTOMGTMESSAGE = valuesCUSTOMGTMESSAGE.get();
//						System.out.println(listofWordsCUSTOMGTMESSAGE);
//					}
//				}

				////// GTS RULE //////////////
				if (existKeyBlacklistedGT.get().toString().equals("1")) {
					System.out.println(" the key exist check blackListGT");
					// Check existKeyAlllistedGT Exist
					RedisFuture<List<String>> valuesBLACKLISTGTS = asyncCommands.zrange("blacklistGts", 0, -1);
					if (!valuesBLACKLISTGTS.get().isEmpty()) {
						listofWordsBLACKLISTGTS = valuesBLACKLISTGTS.get();
						System.out.println(listofWordsBLACKLISTGTS);
					}

				}

				if (existKeyWhitelistedGT.get().toString().equals("1")) {
					System.out.println(" the key exist check whiteListGT");
					// Check existKeyWhitelistedGT Exist
					RedisFuture<List<String>> valuesWHITELISTGTS = asyncCommands.zrange("whitelistGts", 0, -1);
					if (!valuesWHITELISTGTS.get().isEmpty()) {
						listofWordsWHITELISTGTS = valuesWHITELISTGTS.get();
						System.out.println(listofWordsWHITELISTGTS);
					}

				}

				if (existKeyBlackGTRange.get().toString().equals("1")) {
					System.out.println(" the key exist check blackGTRange");
					// Check existKeyWhitelistedGT Exist
					RedisFuture<List<String>> valuesGTRange = asyncCommands.zrange("gtsRange", 0, -1);
					if (!valuesGTRange.get().isEmpty()) {
						listofWordsSMSGTRANGEBLACK = valuesGTRange.get();
						System.out.println(listofWordsSMSGTRANGEBLACK);
					}

				}

				if (existKeyWhiteGTRange.get().toString().equals("1")) {
					System.out.println(" the key exist check whiteGTRange");
					// Check existKeyWhitelistedGT Exist
					RedisFuture<List<String>> valuesGTRangeWhite = asyncCommands.zrange("whitegtsRange", 0, -1);
					if (!valuesGTRangeWhite.get().isEmpty()) {
						listofWordsSMSGTRANGEWHITE = valuesGTRangeWhite.get();
						System.out.println(listofWordsSMSGTRANGEWHITE);
					}

				}

			//	MessageObject object = checkCustomRule(msg, sender, remoteGT);
				
				// System.out.println("the object:" + object);

//				if (object != null) {
//
//					if (object.getStatus().contains("1")) {
//						System.out.println("Message will not be forwaded for ModuleHelper.checkCustom:");
//						System.out.println("The object is : " + object);
//						// if(object.getCodeBlock().equals("M-S-R")) {
//						// System.out.println("r");
//						//
//						// }else {
//						// System.err.println("we have nothing");
//						// }
//						//
//					} else {
//						System.out.println("Message will be forwaded successfully ModuleHelper.checkCustom");
//
//					}
//
//				} else {
//					System.out.println("object is NULL");
//				}
				
				if (checkGTS(localAddressGT, remoteAddressGT) == false) {
					
					System.out.println("Message will not be forwaded for ModuleHelper.checkGTS");
					
				} else {
					
					System.out.println("Message will be forwaded Normally");
					
				}
				
				

			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("An error has occured: " + e);
			}

		} else {
			System.out.println("connection failed");
		}

	}

	public static MessageObject checkCustomRule(String message, String senderId, String remoteAddressGT) {

		Gson gson = new Gson();
		MessageObject init = null;

		// Message and SenderId
		if (!listofWordsCUSTOM.isEmpty()) {

			for (int i = 0; i < listofWordsCUSTOM.size(); i++) {
				MessageObject address = gson.fromJson(listofWordsCUSTOM.get(i), MessageObject.class);
				if (message.toLowerCase().contains(address.getMessage().toLowerCase())
						&& senderId.toLowerCase().contains(address.getSenderId().toLowerCase())) {
					init = address;
					init.setCode("M-S");
					break;
				}
			}
		}
		// Message and SenderId and RemoteGT
		if (!listofWordsCUSTOMALL.isEmpty()) {
			for (int i = 0; i < listofWordsCUSTOMALL.size(); i++) {
				MessageObject address = gson.fromJson(listofWordsCUSTOMALL.get(i), MessageObject.class);
				if (message.toLowerCase().contains(address.getMessage().toLowerCase())
						&& remoteAddressGT.contains(address.getGt())
						&& senderId.toLowerCase().contains(address.getSenderId().toLowerCase())) {
					init = address;
					init.setCode("M-S-R");
					break;
				}
			}
		}
		// RemoteGT and SenderID
		if (!listofWordsCUSTOMSENDERGT.isEmpty()) {
			for (int i = 0; i < listofWordsCUSTOMSENDERGT.size(); i++) {
				MessageObject address = gson.fromJson(listofWordsCUSTOMSENDERGT.get(i), MessageObject.class);
				if (remoteAddressGT.contains(address.getGt())
						&& senderId.toLowerCase().contains(address.getSenderId().toLowerCase())) {
					init = address;
					init.setCode("S-R");
					break;
				}
			}
		}
		// Message and RemoteGT
		if (!listofWordsCUSTOMGTMESSAGE.isEmpty()) {
			for (int i = 0; i < listofWordsCUSTOMGTMESSAGE.size(); i++) {
				MessageObject address = gson.fromJson(listofWordsCUSTOMGTMESSAGE.get(i), MessageObject.class);
				if (message.toLowerCase().contains(address.getMessage().toLowerCase())
						&& remoteAddressGT.contains(address.getGt())) {
					init = address;
					init.setCode("M-R");
					break;
				}
			}
		}

		return init;

	}
	// Local GT is never used !!!!!!!!! only remote is used in all acenarios
	public static boolean checkGTS(String localGt, String remoteGt) throws InterruptedException, ExecutionException {

		Boolean outcome = null;

		String value = "2";

		switch (value) {
		// Need Tobe Removed 0 new changes Tomorrow
		// case "0":
		// MapRoutingSbb.log.info("the value is :" + value + " Block all GT");
		// outcome = false;
		// break;
		case "1":
			System.out.println("the value is :" + value + " Accept all GT");
			outcome = true;
			break;
		case "2":
			System.out.println("the value is :" + value + " BlackListGT");
			if (!listofWordsBLACKLISTGTS.isEmpty() || !listofWordsSMSGTRANGEBLACK.isEmpty()) {

				System.out.println("we have blackGT or blackGTRANGE");
				ArrayList<String> listofFindWordsblackGT = new ArrayList<String>();
				ArrayList<String> listofFindWordsblackGTRANGE = new ArrayList<String>();
				if (!listofWordsBLACKLISTGTS.isEmpty()) {
					String patternString = "\\b(" + StringUtils.join(listofWordsBLACKLISTGTS, "|") + ")\\b";
					Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
					// Matcher for remoteGt
					Matcher matcher2 = pattern.matcher(remoteGt);
					while (matcher2.find()) {
						listofFindWordsblackGT.add(matcher2.group(1));
						break;
					}
				}

				if (!listofWordsSMSGTRANGEBLACK.isEmpty()) {
					Gson gson = new Gson();
					// int rmGT = Integer.parseInt(remoteGt.trim());
					long rmGT = Long.parseLong(remoteGt.trim());

					for (int i = 0; i < listofWordsSMSGTRANGEBLACK.size(); i++) {
						GtsRange object = gson.fromJson(listofWordsSMSGTRANGEBLACK.get(i), GtsRange.class);

						long from = Long.parseLong(object.getFrom().trim());
						long to = Long.parseLong(object.getTo().trim());
						if (rmGT >= from && rmGT <= to) {
							listofFindWordsblackGTRANGE.add("FOUND");

						}
					}
				}

				if (!listofFindWordsblackGT.isEmpty() || !listofFindWordsblackGTRANGE.isEmpty()) {
					outcome = false;
				} else {
					outcome = true;
				}

			} else {
				System.out.println(" BlackGT or BlackGTRANGE is EMPTY ");
				outcome = true;
			}
			break;
		case "3":
			System.out.println("the value is :" + value + "WhiteListGT");

			if (!listofWordsWHITELISTGTS.isEmpty() || !listofWordsSMSGTRANGEWHITE.isEmpty()) {

				System.out.println("we have whiteGT or whiteGTRANGE");
				ArrayList<String> listofFindWordswhiteGT = new ArrayList<String>();
				ArrayList<String> listofFindWordswhiteGTRANGE = new ArrayList<String>();

				if (!listofWordsWHITELISTGTS.isEmpty()) {
					String patternString = "\\b(" + StringUtils.join(listofWordsWHITELISTGTS, "|") + ")\\b";
					Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
					// Matcher for remoteGt
					Matcher matcher2 = pattern.matcher(remoteGt);
					while (matcher2.find()) {
						listofFindWordswhiteGT.add(matcher2.group(1));
						break;
					}
				}

				if (!listofWordsSMSGTRANGEWHITE.isEmpty()) {
					Gson gson = new Gson();
					// int rmGT = Integer.parseInt(remoteGt.trim());
					long rmGT = Long.parseLong(remoteGt.trim());
					for (int i = 0; i < listofWordsSMSGTRANGEWHITE.size(); i++) {
						GtsRange object = gson.fromJson(listofWordsSMSGTRANGEWHITE.get(i), GtsRange.class);
						long from = Long.parseLong(object.getFrom().trim());
						long to = Long.parseLong(object.getTo().trim());
						if (rmGT >= from && rmGT <= to) {
							listofFindWordswhiteGTRANGE.add("FOUND");
						}
					}
				}

				if (!listofFindWordswhiteGT.isEmpty() || !listofFindWordswhiteGTRANGE.isEmpty()) {
					// it's inside white list .... let it through
					outcome = true;
				} else {
					outcome = false;
				}
			} else {
				System.out.println("WhiteGT or WhiteGTRANGE is EMPTY ");
				outcome = false;
			}

			break;
		default:
			outcome = true;
		}

		return outcome;

	}

}
