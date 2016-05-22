package org.kluge;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceProviderResolver;
import javax.persistence.spi.PersistenceProviderResolverHolder;
import java.util.Collections;
import java.util.List;

/**
 * Created by giko on 5/22/2016.
 */
@Configuration
public class HibernatePersistenceProviderResolver implements PersistenceProviderResolver {
    private volatile PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();

    @Override
    public List<PersistenceProvider> getPersistenceProviders() {
        return Collections.singletonList(persistenceProvider);
    }

    @Override
    public void clearCachedProviders() {
        persistenceProvider = new HibernatePersistenceProvider();
    }

    @PostConstruct
    public void register() {
        PersistenceProviderResolverHolder.setPersistenceProviderResolver(new HibernatePersistenceProviderResolver());
    }
}