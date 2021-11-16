/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * SPI for cache providers.
 *
 * 每个 namespace 都会创建一个 cache 实例
 *
 * cache 实现类必须有一个接受 cache id 字符串参数的构造器
 *
 * <pre>
 * public MyCache(final String id) {
 *  if (id == null) {
 *    throw new IllegalArgumentException("Cache instances require an ID");
 *  }
 *  this.id = id;
 *  initialize();
 * }
 * </pre>
 */

public interface Cache {

  /** 获取当前缓存的 id */
  String getId();

  /**
   * @param key 一般为 {@link CacheKey} 对象
   * @param value 是 select 语句的结果
   */
  void putObject(Object key, Object value);

  /** 根据 key 获取缓存 */
  Object getObject(Object key);

  /** 删除指定 key 的缓存 */
  Object removeObject(Object key);

  /** 清空缓存 */
  void clear();

  /** 获取缓存大小 */
  int getSize();

  /** 获取读写锁 */
  ReadWriteLock getReadWriteLock();

}