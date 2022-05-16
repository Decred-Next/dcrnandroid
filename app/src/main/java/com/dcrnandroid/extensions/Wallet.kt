/*
 * Copyright (c) 2018-2019 The Decred developers
 * Use of this source code is governed by an ISC
 * license that can be found in the LICENSE file.
 */

package com.dcrnandroid.extensions

import com.dcrnandroid.data.Account
import com.dcrnandroid.data.parseAccounts
import dcrlibwallet.Wallet

fun Wallet.walletAccounts(): ArrayList<Account> {
    return parseAccounts(this.accounts).accounts
}

fun Wallet.totalWalletBalance(): Long {
    val visibleAccounts = this.walletAccounts()

    return visibleAccounts.map { it.balance.total }.reduce { sum, element -> sum + element }
}
