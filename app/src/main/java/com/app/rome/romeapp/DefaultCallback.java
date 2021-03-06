// ------------------------------------------------------------------------------
// Copyright (c) 2015 Microsoft Corporation
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
// ------------------------------------------------------------------------------

package com.app.rome.romeapp;

import com.microsoft.graph.concurrency.ICallback;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import com.microsoft.graph.core.ClientException;

public class DefaultCallback<T> implements ICallback<T>{

        /**
         * The exception text for not implemented runtime exceptions
         */
        private static final String SUCCESS_MUST_BE_IMPLEMENTED = "Success must be implemented";

        /**
         * The context used for displaying toast notifications
         */
        private final Context mContext;

        /**
         * Default constructor
         * @param context The context used for displaying toast notifications
         */
        public DefaultCallback(final Context context) {
            mContext = context;
        }
        @Override
        public void success(final T t) {
            throw new RuntimeException(SUCCESS_MUST_BE_IMPLEMENTED);
        }

        @Override
        public void failure(final ClientException error) {
            if (error != null) {
                Log.e(getClass().getSimpleName(), error.getMessage());
                new AlertDialog
                        .Builder(mContext)
                        .setTitle("Error")
                        .setMessage(error.getMessage())
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialog, final int which) {
                                dialog.dismiss();
                            }
                        })
                        .create()
                        .show();
            }
        }
    }



