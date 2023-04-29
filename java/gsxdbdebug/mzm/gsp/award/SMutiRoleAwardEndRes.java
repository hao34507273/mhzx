/*    */ package mzm.gsp.award;
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
/*    */ 
/*    */ public class SMutiRoleAwardEndRes
/*    */   extends __SMutiRoleAwardEndRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583437;
/*    */   public long awarduuid;
/*    */   public HashMap<Integer, MultiRoleAwardBean> index2award;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12583437;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SMutiRoleAwardEndRes()
/*    */   {
/* 34 */     this.index2award = new HashMap();
/*    */   }
/*    */   
/*    */   public SMutiRoleAwardEndRes(long _awarduuid_, HashMap<Integer, MultiRoleAwardBean> _index2award_) {
/* 38 */     this.awarduuid = _awarduuid_;
/* 39 */     this.index2award = _index2award_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Map.Entry<Integer, MultiRoleAwardBean> _e_ : this.index2award.entrySet()) {
/* 44 */       if (!((MultiRoleAwardBean)_e_.getValue())._validator_()) return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.awarduuid);
/* 51 */     _os_.compact_uint32(this.index2award.size());
/* 52 */     for (Map.Entry<Integer, MultiRoleAwardBean> _e_ : this.index2award.entrySet()) {
/* 53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 54 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.awarduuid = _os_.unmarshal_long();
/* 61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 63 */       int _k_ = _os_.unmarshal_int();
/* 64 */       MultiRoleAwardBean _v_ = new MultiRoleAwardBean();
/* 65 */       _v_.unmarshal(_os_);
/* 66 */       this.index2award.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SMutiRoleAwardEndRes)) {
/* 77 */       SMutiRoleAwardEndRes _o_ = (SMutiRoleAwardEndRes)_o1_;
/* 78 */       if (this.awarduuid != _o_.awarduuid) return false;
/* 79 */       if (!this.index2award.equals(_o_.index2award)) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += (int)this.awarduuid;
/* 88 */     _h_ += this.index2award.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.awarduuid).append(",");
/* 96 */     _sb_.append(this.index2award).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\SMutiRoleAwardEndRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */