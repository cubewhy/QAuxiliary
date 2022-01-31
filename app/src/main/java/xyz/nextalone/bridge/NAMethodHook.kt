/*
 * QAuxiliary - An Xposed module for QQ/TIM
 * Copyright (C) 2019-2022 qwq233@qwq2333.top
 * https://github.com/cinit/QAuxiliary
 *
 * This software is non-free but opensource software: you can redistribute it
 * and/or modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either
 * version 3 of the License, or any later version and our eula as published
 * by ferredoxin.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * and eula along with this software.  If not, see
 * <https://www.gnu.org/licenses/>
 * <https://github.com/cinit/QAuxiliary/blob/master/LICENSE.md>.
 */

package xyz.nextalone.bridge

import de.robv.android.xposed.XC_MethodHook
import io.github.qauxv.base.IDynamicHook
import io.github.qauxv.util.LicenseStatus
import io.github.qauxv.util.Log

abstract class NAMethodHook(baseHook: IDynamicHook) : XC_MethodHook() {
    open val hook = baseHook

    @Throws(Throwable::class)
    override fun beforeHookedMethod(param: MethodHookParam) {
        try {
            if (!hook.isEnabled or LicenseStatus.sDisableCommonHooks) return
            beforeMethod(param)
        } catch (e: Exception) {
            Log.e(e)
        }
    }

    @Throws(Throwable::class)
    override fun afterHookedMethod(param: MethodHookParam) {
        try {
            if (!hook.isEnabled or LicenseStatus.sDisableCommonHooks) return
            afterMethod(param)
        } catch (e: Exception) {
            Log.e(e)
        }
    }

    @Throws(Throwable::class)
    protected open fun beforeMethod(param: MethodHookParam) {
    }

    @Throws(Throwable::class)
    protected open fun afterMethod(param: MethodHookParam) {
    }
}
