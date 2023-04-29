/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VerifyMaster2
/*    */   extends __VerifyMaster2__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 604;
/*    */   public int zoneid;
/*    */   public long roleid;
/*    */   public Octets rolename;
/*    */   public Octets faction;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 604;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public VerifyMaster2()
/*    */   {
/* 34 */     this.roleid = -1L;
/* 35 */     this.rolename = new Octets();
/* 36 */     this.faction = new Octets();
/*    */   }
/*    */   
/*    */   public VerifyMaster2(int _zoneid_, long _roleid_, Octets _rolename_, Octets _faction_) {
/* 40 */     this.zoneid = _zoneid_;
/* 41 */     this.roleid = _roleid_;
/* 42 */     this.rolename = _rolename_;
/* 43 */     this.faction = _faction_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.zoneid);
/* 52 */     _os_.marshal(this.roleid);
/* 53 */     _os_.marshal(this.rolename);
/* 54 */     _os_.marshal(this.faction);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.zoneid = _os_.unmarshal_int();
/* 60 */     this.roleid = _os_.unmarshal_long();
/* 61 */     this.rolename = _os_.unmarshal_Octets();
/* 62 */     this.faction = _os_.unmarshal_Octets();
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof VerifyMaster2)) {
/* 72 */       VerifyMaster2 _o_ = (VerifyMaster2)_o1_;
/* 73 */       if (this.zoneid != _o_.zoneid) return false;
/* 74 */       if (this.roleid != _o_.roleid) return false;
/* 75 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 76 */       if (!this.faction.equals(_o_.faction)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.zoneid;
/* 85 */     _h_ += (int)this.roleid;
/* 86 */     _h_ += this.rolename.hashCode();
/* 87 */     _h_ += this.faction.hashCode();
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.zoneid).append(",");
/* 95 */     _sb_.append(this.roleid).append(",");
/* 96 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 97 */     _sb_.append("B").append(this.faction.size()).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\VerifyMaster2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */