/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynRoleExchangeUseItemInfo
/*    */   extends __SSynRoleExchangeUseItemInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584877;
/*    */   public HashMap<Integer, ExchangeUseItemInfo> role_exchange_use_item_infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584877;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynRoleExchangeUseItemInfo()
/*    */   {
/* 31 */     this.role_exchange_use_item_infos = new HashMap();
/*    */   }
/*    */   
/*    */   public SSynRoleExchangeUseItemInfo(HashMap<Integer, ExchangeUseItemInfo> _role_exchange_use_item_infos_) {
/* 35 */     this.role_exchange_use_item_infos = _role_exchange_use_item_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     for (Map.Entry<Integer, ExchangeUseItemInfo> _e_ : this.role_exchange_use_item_infos.entrySet()) {
/* 40 */       if (!((ExchangeUseItemInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.compact_uint32(this.role_exchange_use_item_infos.size());
/* 47 */     for (Map.Entry<Integer, ExchangeUseItemInfo> _e_ : this.role_exchange_use_item_infos.entrySet()) {
/* 48 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 49 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 57 */       int _k_ = _os_.unmarshal_int();
/* 58 */       ExchangeUseItemInfo _v_ = new ExchangeUseItemInfo();
/* 59 */       _v_.unmarshal(_os_);
/* 60 */       this.role_exchange_use_item_infos.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SSynRoleExchangeUseItemInfo)) {
/* 71 */       SSynRoleExchangeUseItemInfo _o_ = (SSynRoleExchangeUseItemInfo)_o1_;
/* 72 */       if (!this.role_exchange_use_item_infos.equals(_o_.role_exchange_use_item_infos)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.role_exchange_use_item_infos.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.role_exchange_use_item_infos).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SSynRoleExchangeUseItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */