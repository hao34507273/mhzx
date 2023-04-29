/*    */ package mzm.gsp.singlebattle;
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
/*    */ 
/*    */ public class SBrdRoleBuffInfo
/*    */   extends __SBrdRoleBuffInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621598;
/*    */   public HashMap<Long, RoleBuffInfo> role_buff_infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12621598;
/*    */   }
/*    */   
/*    */ 
/*    */   public SBrdRoleBuffInfo()
/*    */   {
/* 33 */     this.role_buff_infos = new HashMap();
/*    */   }
/*    */   
/*    */   public SBrdRoleBuffInfo(HashMap<Long, RoleBuffInfo> _role_buff_infos_) {
/* 37 */     this.role_buff_infos = _role_buff_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (Map.Entry<Long, RoleBuffInfo> _e_ : this.role_buff_infos.entrySet()) {
/* 42 */       if (!((RoleBuffInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.compact_uint32(this.role_buff_infos.size());
/* 49 */     for (Map.Entry<Long, RoleBuffInfo> _e_ : this.role_buff_infos.entrySet()) {
/* 50 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/* 51 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 59 */       long _k_ = _os_.unmarshal_long();
/* 60 */       RoleBuffInfo _v_ = new RoleBuffInfo();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.role_buff_infos.put(Long.valueOf(_k_), _v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SBrdRoleBuffInfo)) {
/* 73 */       SBrdRoleBuffInfo _o_ = (SBrdRoleBuffInfo)_o1_;
/* 74 */       if (!this.role_buff_infos.equals(_o_.role_buff_infos)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.role_buff_infos.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.role_buff_infos).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SBrdRoleBuffInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */