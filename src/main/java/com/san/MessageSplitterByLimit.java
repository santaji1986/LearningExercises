package com.san;

import java.util.ArrayList;
import java.util.List;
/**
 * @description       : This class is designed for splitting message into chunks based on limit and
 * add chunk suffix for each chunk.
 * corner cases are not handled, like very short message or very long message with too short limit.
 * @author            : Santaji Suryawanshi
 * @last modified on  : 16-02-2024
 **/
public class MessageSplitterByLimit {
        public static void main(String[] args) {
            String message = "hello, world!";
            int limit = 10;
            String[] output = splitMessage(message, limit);
            for (String chunk : output) {
                System.out.println(chunk);
            }
        }

        public static String[] splitMessage(String message, int limit) {
            int chunkLength = getChunkLength(message.length(), limit);
            List<String> list = new ArrayList<>();
            int totalChunkCount = (int) Math.ceil((double) message.length() / (limit - chunkLength));
            int newMessageLimit = limit - chunkLength;
            for (int i = 0; i < totalChunkCount; i++) {
                int start = i * newMessageLimit;
                int end = Math.min(start + newMessageLimit, message.length());
                String tempMessage = message.substring(start, end) + "<" + (i + 1) + "/" + totalChunkCount + ">";
                list.add(tempMessage);
            }
            return list.toArray(new String[0]);
        }

        public static int getChunkLength(int messageLength, int messageLimit) {
            String chunkPlaceholder = "<%d/%d>";
            String chunkPrefix = String.format(chunkPlaceholder, 0, 0);

            int totalChunkCount = (int) Math.ceil((double) messageLength / (messageLimit - chunkPrefix.length()));
            if (totalChunkCount > 9) {
                chunkPrefix = String.format(chunkPlaceholder, totalChunkCount, totalChunkCount);
                totalChunkCount = (int) Math.ceil((double) messageLength / (messageLimit - chunkPrefix.length()));
                chunkPrefix = String.format(chunkPlaceholder, totalChunkCount, totalChunkCount);
            }
            System.out.println("chunkPrefix == "+chunkPrefix+", chunkPrefix.length() == "+chunkPrefix.length());
            return chunkPrefix.length();
        }
    }
