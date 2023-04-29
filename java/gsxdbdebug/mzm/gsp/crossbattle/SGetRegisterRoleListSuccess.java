/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SGetRegisterRoleListSuccess
/*    */   extends __SGetRegisterRoleListSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617004;
/*    */   public int activity_cfg_id;
/*    */   public long corps_id;
/*    */   public ArrayList<Long> role_list;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617004;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetRegisterRoleListSuccess()
/*    */   {
/* 35 */     this.role_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public SGetRegisterRoleListSuccess(int _activity_cfg_id_, long _corps_id_, ArrayList<Long> _role_list_) {
/* 39 */     this.activity_cfg_id = _activity_cfg_id_;
/* 40 */     this.corps_id = _corps_id_;
/* 41 */     this.role_list = _role_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activity_cfg_id);
/* 50 */     _os_.marshal(this.corps_id);
/* 51 */     _os_.compact_uint32(this.role_list.size());
/* 52 */     for (Long _v_ : this.role_list) {
/* 53 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 60 */     this.corps_id = _os_.unmarshal_long();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       long _v_ = _os_.unmarshal_long();
/* 64 */       this.role_list.add(Long.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SGetRegisterRoleListSuccess)) {
/* 75 */       SGetRegisterRoleListSuccess _o_ = (SGetRegisterRoleListSuccess)_o1_;
/* 76 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 77 */       if (this.corps_id != _o_.corps_id) return false;
/* 78 */       if (!this.role_list.equals(_o_.role_list)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.activity_cfg_id;
/* 87 */     _h_ += (int)this.corps_id;
/* 88 */     _h_ += this.role_list.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activity_cfg_id).append(",");
/* 96 */     _sb_.append(this.corps_id).append(",");
/* 97 */     _sb_.append(this.role_list).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetRegisterRoleListSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */