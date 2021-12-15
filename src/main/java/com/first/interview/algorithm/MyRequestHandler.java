package com.first.interview.algorithm;

interface IHandler {
    String handle(String htmlFilePath);
}


class MyRequestHandler implements IHandler {
    private long count = 0;

    public String handle(String htmlFilePath) {
        synchronized (this) {
            count++;
        }
//        return retrieveFile(htmlFilePath);
        return "retrieveFile";
    }

    private synchronized void incrementCount() {
        count++;
    }

    public long getNumPageVisits() {
        return count;
    }

}

