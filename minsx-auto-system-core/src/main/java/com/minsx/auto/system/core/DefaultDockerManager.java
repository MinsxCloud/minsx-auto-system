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
package com.minsx.auto.system.core;

import com.minsx.auto.system.api.DockerContainer;
import com.minsx.auto.system.api.DockerManager;
import com.minsx.auto.system.api.exception.DockerRunException;
import com.minsx.framework.common.shell.core.Shell;

public class DefaultDockerManager implements DockerManager {

    @Override
    public DockerContainer runImage(String imageId) throws DockerRunException {
        String command = String.format("docker run %s", imageId);
        Shell shell = Shell.build(command).sync(false);
        StringBuffer out =new StringBuffer();
        StringBuffer error =new StringBuffer();
        shell.onOut((line, operator) -> {
            out.append(line);
        });
        shell.onErr((line, operator) -> {
            error.append(line);
        });
        shell.onException(e -> {
            shell.stop();
            throw new DockerRunException("Run docker image error",e,command,out.toString(),error.toString());
        });
        shell.run();
        if (shell.exitCode() != 0) throw new DockerRunException("Run docker image error",command,out.toString(),error.toString());
        return null;
    }

    @Override
    public DockerContainer stopImage(String imageId) throws Exception {
        Shell shell = Shell.build(String.format("docker stop %s", imageId)).sync(false);
        shell.run();
        if (shell.exitCode() != 0) throw new Exception("");
        return null;
    }

}
