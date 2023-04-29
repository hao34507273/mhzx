/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.point.PCPointRaceReady;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPointRaceReady
/*    */   extends __CPointRaceReady__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617010;
/*    */   public int activity_cfgid;
/*    */   public int index;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCPointRaceReady(roleId, this.activity_cfgid, this.index));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12617010;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CPointRaceReady() {}
/*    */   
/*    */ 
/*    */   public CPointRaceReady(int _activity_cfgid_, int _index_)
/*    */   {
/* 42 */     this.activity_cfgid = _activity_cfgid_;
/* 43 */     this.index = _index_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activity_cfgid);
/* 52 */     _os_.marshal(this.index);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.activity_cfgid = _os_.unmarshal_int();
/* 58 */     this.index = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CPointRaceReady)) {
/* 68 */       CPointRaceReady _o_ = (CPointRaceReady)_o1_;
/* 69 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 70 */       if (this.index != _o_.index) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.activity_cfgid;
/* 79 */     _h_ += this.index;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.activity_cfgid).append(",");
/* 87 */     _sb_.append(this.index).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CPointRaceReady _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.activity_cfgid - _o_.activity_cfgid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.index - _o_.index;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CPointRaceReady.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */