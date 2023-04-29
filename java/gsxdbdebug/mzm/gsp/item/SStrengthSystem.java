/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SStrengthSystem
/*    */   extends __SStrengthSystem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584714;
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   public int equipcfgid;
/*    */   public int strengthlevel;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584714;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SStrengthSystem()
/*    */   {
/* 34 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public SStrengthSystem(long _roleid_, String _rolename_, int _equipcfgid_, int _strengthlevel_) {
/* 38 */     this.roleid = _roleid_;
/* 39 */     this.rolename = _rolename_;
/* 40 */     this.equipcfgid = _equipcfgid_;
/* 41 */     this.strengthlevel = _strengthlevel_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.roleid);
/* 50 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 51 */     _os_.marshal(this.equipcfgid);
/* 52 */     _os_.marshal(this.strengthlevel);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.roleid = _os_.unmarshal_long();
/* 58 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 59 */     this.equipcfgid = _os_.unmarshal_int();
/* 60 */     this.strengthlevel = _os_.unmarshal_int();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SStrengthSystem)) {
/* 70 */       SStrengthSystem _o_ = (SStrengthSystem)_o1_;
/* 71 */       if (this.roleid != _o_.roleid) return false;
/* 72 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 73 */       if (this.equipcfgid != _o_.equipcfgid) return false;
/* 74 */       if (this.strengthlevel != _o_.strengthlevel) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += (int)this.roleid;
/* 83 */     _h_ += this.rolename.hashCode();
/* 84 */     _h_ += this.equipcfgid;
/* 85 */     _h_ += this.strengthlevel;
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.roleid).append(",");
/* 93 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 94 */     _sb_.append(this.equipcfgid).append(",");
/* 95 */     _sb_.append(this.strengthlevel).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SStrengthSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */