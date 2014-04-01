/*
 * Copyright 2012 Steve Chaloner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.objectify.deadbolt.java.utils;

import static play.api.Play.unsafeApplication;
import static play.libs.Scala.orNull;

import be.objectify.deadbolt.java.DeadboltHandler;
import be.objectify.deadbolt.java.DeadboltPlugin;

public class PluginUtils
{
    public static DeadboltPlugin getDeadboltPlugin() throws Exception
    {
        DeadboltPlugin plugin = orNull(unsafeApplication().plugin(DeadboltPlugin.class));
        if (plugin == null)
        {
            throw new Exception("The Deadbolt Java plugin was not registered,  or is disabled.  Please check your conf/play.plugins file.");
        }
        return plugin;
    }

    public static boolean isUserCacheEnabled() throws Exception
    {
        DeadboltPlugin p = getDeadboltPlugin();
        return p != null && p.isCacheUserPerRequestEnabled();
    }

    public static int getBeforeAuthCheckTimeout() throws Exception
    {
        DeadboltPlugin p = getDeadboltPlugin();
        return p.getBeforeAuthCheckTimeout();
    }

    public static DeadboltHandler getDeadboltHandler() throws Exception
    {
        DeadboltPlugin p = getDeadboltPlugin();
        return p != null ? p.getDeadboltHandler() : null;
    }

    public static DeadboltHandler getDeadboltHandler(String handlerKey) throws Exception
    {
        DeadboltPlugin p = getDeadboltPlugin();
        return p != null ? p.getDeadboltHandler(handlerKey) : null;
    }
}
