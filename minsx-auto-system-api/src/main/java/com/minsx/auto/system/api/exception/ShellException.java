/*
 *
 *  * Copyright © 2017-2018 minsx.com All rights reserved
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */
package com.minsx.auto.system.api.exception;

public class ShellException extends RuntimeException {

    private String command;
    private String out;
    private String error;

    public ShellException(String message, String command, String out, String error) {
        super(message);
        this.command = command;
        this.out = out;
        this.error = error;
    }

    public ShellException(String message, Throwable cause, String command, String out, String error) {
        super(message, cause);
        this.command = command;
        this.out = out;
        this.error = error;
    }

    public ShellException(Throwable cause, String command, String out, String error) {
        super(cause);
        this.command = command;
        this.out = out;
        this.error = error;
    }

    public ShellException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String command, String out, String error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.command = command;
        this.out = out;
        this.error = error;
    }


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
