package org.apache.solr.client.solrj.util;

import java.util.regex.Pattern;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Ensures that provided identifiers align with Solr's recommendations/requirements for choosing
 * collection, core, etc identifiers.
 *  
 * Identifiers are allowed to contain underscores, periods, and alphanumeric characters. 
 */
public class SolrIdentifierValidator {
  final static Pattern identifierPattern = Pattern.compile("^[\\._A-Za-z0-9]*$");
  
  public static boolean validateShardName(String shardName) {
    return validateIdentifier(shardName);
  }
  
  public static boolean validateCollectionName(String collectionName) {
    return validateIdentifier(collectionName);
  }
  
  public static boolean validateCoreName(String name) {
    return validateIdentifier(name);
  }
  
  private static boolean validateIdentifier(String identifier) {
    if (identifier == null || ! identifierPattern.matcher(identifier).matches()) {
      return false;
    }
    return true;
  }
}


