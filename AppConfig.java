/**
 * 
 */
package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Lakhan Patel
 * CodeBreaker
 */
@Configuration
@Import({PersistenceConfig.class,ServiceConfig.class})
public class AppConfig {

}
