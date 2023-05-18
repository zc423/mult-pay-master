/*
 * Copyright (c) 2021-2031, 河北计全科技有限公司 (https://www.jeequan.com & jeequan@126.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.thgold.thgplatform.bank.payment.channel.paychaannel.wxpay;

import com.thgold.thgplatform.bank.payment.bo.MerchantProductConfig;
import com.thgold.thgplatform.bank.payment.bo.PayOrder;
import com.thgold.thgplatform.bank.payment.bo.Result;
import com.thgold.thgplatform.bank.payment.channel.impl.AbstractChannelService;
import com.thgold.thgplatform.bank.payment.constant.ConstantEnum;
import org.springframework.stereotype.Service;

/**
 * 微信v3支付
 */
@Service
public class WxPayV3PaymentService extends AbstractChannelService {

    /**
     * 支付
     *
     * @param merchant
     * @param payOrder
     * @return
     */
    @Override
    public Result pay(MerchantProductConfig merchant, PayOrder payOrder) {
        return null;
    }

    /**
     * 支付参数校验
     *
     * @param merchant
     * @param payOrder
     * @return
     */
    @Override
    public Boolean preCheckParams(MerchantProductConfig merchant, PayOrder payOrder) {
        return null;
    }

    @Override
    public ConstantEnum.PayServiceTypeEnum getPayType() {
        return ConstantEnum.PayServiceTypeEnum.WX_MINI_MP_V3;
    }
}
