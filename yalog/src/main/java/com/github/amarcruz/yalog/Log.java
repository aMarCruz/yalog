/*
 * Copyright 2018 Alberto Martínez
 *
 * Licensed under the MIT License; you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * https://github.com/aMarCruz/yalog/blob/master/LICENSE
 */
package com.github.amarcruz.yalog;

import java.util.HashMap;

public final class Log {

    // From most to least verbosity
    /**
     * Priority constant for the println method; use Log.v.
     */
    public static final int VERBOSE = android.util.Log.VERBOSE; // 2

    /**
     * Priority constant for the println method; use Log.d.
     */
    public static final int DEBUG = android.util.Log.DEBUG; // 3

    /**
     * Priority constant for the println method; use Log.i.
     */
    public static final int INFO = android.util.Log.INFO; // 4

    /**
     * Priority constant for the println method; use Log.w.
     */
    public static final int WARN = android.util.Log.WARN; // 5

    /**
     * Priority constant for the println method; use Log.e.
     */
    public static final int ERROR = android.util.Log.ERROR; // 6

    /**
     * Priority constant for the println method.
     */
    public static final int ASSERT = android.util.Log.ASSERT; // 7

    /**
     * ALL indicates that all messages should be logged.
     * This level is initialized to Integer.MIN_VALUE.
     */
    public static final int ALL = Integer.MIN_VALUE;

    /**
     * SUPPRESS is a special level that can be used to turn off logging.
     * This level is initialized to Integer.MAX_VALUE.
     */
    public static final int SUPPRESS = Integer.MAX_VALUE;

    // ------------------------------------------------------------------------
    //  Private fields and constructors
    // ------------------------------------------------------------------------

    private static int mLevel = INFO;
    private static HashMap<String, Integer> mTagLevels = new HashMap<>();

    private Log() {}

    // ------------------------------------------------------------------------
    //  VERBOSE
    // ------------------------------------------------------------------------

    /**
     * Send a {@link #VERBOSE} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return The number of bytes written.
     */
    public static int v(final String tag, final String msg) {
        return _print(VERBOSE, tag, msg);
    }

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     * @return The number of bytes written.
     */
    public static int v(final String tag, final String msg, final Throwable tr) {
        return _print(VERBOSE, tag, msg, tr);
    }

    /**
     * Send a {@link #VERBOSE} log message.
     * @param tag  tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg  The message you would like logged.
     * @param args Arguments passed to {@link java.lang.String#format(String, Object... args)}. May be null.
     * @return The number of bytes written.
     */
    public static int v(final String tag, final String msg, Object... args) {
        return _print(VERBOSE, tag, msg, args);
    }

    // ------------------------------------------------------------------------
    //  DEBUG
    // ------------------------------------------------------------------------

    /**
     * Send a {@link #DEBUG} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return The number of bytes written.
     */
    public static int d(final String tag, final String msg) {
        return _print(DEBUG, tag, msg);
    }

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     * @return The number of bytes written.
     */
    public static int d(final String tag, final String msg, final Throwable tr) {
        return _print(DEBUG, tag, msg, tr);
    }

    /**
     * Send a {@link #DEBUG} log message.
     * @param tag  tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg  The message you would like logged.
     * @param args Arguments passed to {@link java.lang.String#format(String, Object... args)}. May be null.
     * @return The number of bytes written.
     */
    public static int d(final String tag, final String msg, Object... args) {
        return _print(DEBUG, tag, msg, args);
    }

    // ------------------------------------------------------------------------
    //  INFO
    // ------------------------------------------------------------------------

    /**
     * Send an {@link #INFO} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return The number of bytes written.
     */
    public static int i(final String tag, final String msg) {
        return _print(INFO, tag, msg);
    }

    /**
     * Send a {@link #INFO} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     * @return The number of bytes written.
     */
    public static int i(final String tag, final String msg, final Throwable tr) {
        return _print(INFO, tag, msg, tr);
    }

    /**
     * Send a {@link #INFO} log message.
     * @param tag  tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg  The message you would like logged.
     * @param args Arguments passed to {@link java.lang.String#format(String, Object... args)}. May be null.
     * @return The number of bytes written.
     */
    public static int i(final String tag, final String msg, Object... args) {
        return _print(INFO, tag, msg, args);
    }

    // ------------------------------------------------------------------------
    //  WARN
    // ------------------------------------------------------------------------

    /**
     * Send a {@link #WARN} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return The number of bytes written.
     */
    public static int w(final String tag, final String msg) {
        return _print(WARN, tag, msg);
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param tr An exception to log
     * @return The number of bytes written.
     */
    public static int w(final String tag, final Throwable tr) {
        return _print(WARN, tag, android.util.Log.getStackTraceString(tr));
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     * @return The number of bytes written.
     */
    public static int w(final String tag, final String msg, final Throwable tr) {
        return _print(WARN, tag, msg, tr);
    }

    /**
     * Send a {@link #WARN} log message.
     * @param tag  tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg  The message you would like logged.
     * @param args Arguments passed to {@link java.lang.String#format(String, Object... args)}. May be null.
     * @return The number of bytes written.
     */
    public static int w(final String tag, final String msg, Object... args) {
        return _print(WARN, tag, msg, args);
    }

    // ------------------------------------------------------------------------
    //  ERROR
    // ------------------------------------------------------------------------

    /**
     * Send an {@link #ERROR} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return The number of bytes written.
     */
    public static int e(final String tag, final String msg) {
        return _print(ERROR, tag, msg);
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     * @return The number of bytes written.
     */
    public static int e(final String tag, final String msg, final Throwable tr) {
        return _print(ERROR, tag, msg, tr);
    }

    /**
     * Send a {@link #ERROR} log message.
     * @param tag  tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg  The message you would like logged.
     * @param args Arguments passed to {@link java.lang.String#format(String, Object... args)}. May be null.
     * @return The number of bytes written.
     */
    public static int e(final String tag, final String msg, Object... args) {
        return _print(ERROR, tag, msg, args);
    }

    // ------------------------------------------------------------------------
    //  wtf (What a Terrible Failure)
    // ------------------------------------------------------------------------

    /**
     * What a Terrible Failure: Report a condition that should never happen.
     * The error will always be logged at level ASSERT with the call stack.
     * Depending on system configuration, a report may be added to the
     * {@link android.os.DropBoxManager} and/or the process may be terminated
     * immediately with an error dialog.
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @return The number of bytes written.
     */
    public static int wtf(final String tag, final String msg) {
        if (isLoggable(tag, ASSERT)) {
            return android.util.Log.wtf(tag, msg);
        }
        return 0;
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Similar to {@link #wtf(String, String)}, with an exception to log.
     * @param tag Used to identify the source of a log message.
     * @param tr An exception to log.
     * @return The number of bytes written.
     */
    public static int wtf(final String tag, final Throwable tr) {
        if (isLoggable(tag, ASSERT)) {
            return android.util.Log.wtf(tag, tr);
        }
        return 0;
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Similar to {@link #wtf(String, Throwable)}, with a message as well.
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr An exception to log.  May be null.
     * @return The number of bytes written.
     */
    public static int wtf(final String tag, final String msg, final Throwable tr) {
        if (isLoggable(tag, ASSERT)) {
            return android.util.Log.wtf(tag, msg, tr);
        }
        return 0;
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Similar to {@link #wtf(String, String)}, with a formatted message as well.
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param args Arguments passed to {@link java.lang.String#format(String, Object... args)}. May be null.
     * @return The number of bytes written.
     */
    public static int wtf(final String tag, final String msg, Object... args) {
        if (isLoggable(tag, ASSERT)) {
            return android.util.Log.wtf(tag, formatMessage(msg, args));
        }
        return 0;
    }

    // ------------------------------------------------------------------------
    //  Level management and utilities
    // ------------------------------------------------------------------------

    /**
     * Checks to see whether or not a log for the specified tag is loggable at the specified level.
     *
     *  The default level of any tag is set to ALL. This means that all levels are going to be logged.
     *  You can change the log level of any tag by using:
     *      'setLevel(&lt;TAG&gt;, &lt;LEVEL&gt;)'
     *  Where level is either VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT, or SUPPRESS. SUPPRESS will
     *  turn off all logging for your tag.
     *
     * @param tag The tag to check.
     * @param level The level to check.
     * @return Whether or not that this is allowed to be logged.
     */
    public static boolean isLoggable(final String tag, final int level) {
        return level >= (mTagLevels.containsKey(tag) ? mTagLevels.get(tag) : mLevel);
    }

    /**
     * Allows you to change the default level for all the tags.
     * The tag levels specified with setLevel(&lt;TAG&gt;, &lt;LEVEL&gt;) take precedence.
     * @param level The desired level, either VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT, or SUPPRESS.
     */
    public static void setLevel(int level) {
        mLevel = level;
    }

    /**
     * Allows you to change the level for a specific tag.
     * This takes precedence over the default level specified with setLevel(&lt;LEVEL&gt;).
     * @param tag The specific tag.
     * @param level The desired level, either VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT, or SUPPRESS.
     */
    public static void setLevel(final String tag, final int level) {
        mTagLevels.put(tag, level);
    }

    /**
     * Handy function to get a loggable stack trace from a Throwable
     * @param tr An exception to log
     * @return The formatted stack trace.
     */
    public static String getStackTraceString(Throwable tr) {
        return android.util.Log.getStackTraceString(tr);
    }

    /**
     * Low-level logging call.
     * @param priority The priority/type of this log message
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return The number of bytes written.
     */
    public static int println(int priority, String tag, String msg) {
        return android.util.Log.println(priority, tag, msg);
    }

    // ------------------------------------------------------------------------
    //  Private methods
    // ------------------------------------------------------------------------

    private static String formatMessage(final String msg, Object... args) {
        // Null array is not supposed to be passed into this method, so it must
        // be a single null argument
        if (args == null) {
            args = new Object[]{null};
        }

        if (msg != null && msg.indexOf('%') != -1) {
            return args.length > 0 ? String.format(msg, args) : msg;
        }

        final StringBuilder sb = new StringBuilder();
        sb.append(msg == null ? "null" : msg);
        for (Object arg : args) {
            sb.append("\t");
            sb.append(arg == null ? "null" : arg.toString());
        }
        return sb.toString();
    }

    private static int _print(final int level, final String tag, final String msg) {
        if (isLoggable(tag, level)) {
            return android.util.Log.println(level, tag, msg);
        }
        return 0;
    }

    private static int _print(final int level, final String tag, final String msg, final Throwable tr) {
        if (isLoggable(tag, level)) {
            return android.util.Log.println(level, tag, msg + '\n' + android.util.Log.getStackTraceString(tr));
        }
        return 0;
    }

    private static int _print(final int level, final String tag, final String msg, final Object... args) {
        if (isLoggable(tag, level)) {
            return android.util.Log.println(level, tag, formatMessage(msg, args));
        }
        return 0;
    }

}
