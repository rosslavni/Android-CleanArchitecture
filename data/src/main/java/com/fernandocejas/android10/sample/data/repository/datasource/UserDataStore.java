/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.fernandocejas.android10.sample.data.repository.datasource;

import com.fernandocejas.android10.sample.data.entity.UserEntity;
import java.util.Collection;
import java.util.List;
import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface UserDataStore {
  /**
   * Callback used for clients to be notified when either a user list has been loaded or any error
   * occurred.
   */
  interface UserListCallback {
    void onUserListLoaded(Collection<UserEntity> usersCollection);

    void onError(Exception exception);
  }

  /**
   * Callback used for clients to be notified when either user data has been retrieved successfully
   * or any error occurred.
   */
  interface UserDetailsCallback {
    void onUserEntityLoaded(UserEntity userEntity);

    void onError(Exception exception);
  }

  /**
   * Get an {@link rx.Observable} which will emit a List of
   * {@link com.fernandocejas.android10.sample.domain.User}.
   */
  Observable<List<UserEntity>> getUserEntityList();

  /**
   * Get a {@link UserEntity} by its id.
   *
   * @param id The id to retrieve user data.
   * @param userDetailsCallback A {@link UserDetailsCallback} for notifications.
   */
  void getUserEntityDetails(int id, UserDetailsCallback userDetailsCallback);
}
