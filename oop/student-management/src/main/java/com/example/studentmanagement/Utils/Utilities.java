package com.example.studentmanagement.Utils;

import com.example.studentmanagement.Model.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Utilities {
    public static final String DEFAULT = "default";

    public static Object getResultFromFuture(Future<Object> future) {
        Object result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            return new Response(false,"Something's wrong");
        }
        return result;
    }
}
