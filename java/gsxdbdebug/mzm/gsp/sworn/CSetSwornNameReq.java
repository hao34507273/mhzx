/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.sworn.main.PSetSwornNameReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSetSwornNameReq
/*    */   extends __CSetSwornNameReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597763;
/*    */   public long swornid;
/*    */   public String name1;
/*    */   public String name2;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PSetSwornNameReq(roleid, this.swornid, this.name1, this.name2));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12597763;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CSetSwornNameReq()
/*    */   {
/* 37 */     this.name1 = "";
/* 38 */     this.name2 = "";
/*    */   }
/*    */   
/*    */   public CSetSwornNameReq(long _swornid_, String _name1_, String _name2_) {
/* 42 */     this.swornid = _swornid_;
/* 43 */     this.name1 = _name1_;
/* 44 */     this.name2 = _name2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.swornid);
/* 53 */     _os_.marshal(this.name1, "UTF-16LE");
/* 54 */     _os_.marshal(this.name2, "UTF-16LE");
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.swornid = _os_.unmarshal_long();
/* 60 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/* 61 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof CSetSwornNameReq)) {
/* 71 */       CSetSwornNameReq _o_ = (CSetSwornNameReq)_o1_;
/* 72 */       if (this.swornid != _o_.swornid) return false;
/* 73 */       if (!this.name1.equals(_o_.name1)) return false;
/* 74 */       if (!this.name2.equals(_o_.name2)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += (int)this.swornid;
/* 83 */     _h_ += this.name1.hashCode();
/* 84 */     _h_ += this.name2.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.swornid).append(",");
/* 92 */     _sb_.append("T").append(this.name1.length()).append(",");
/* 93 */     _sb_.append("T").append(this.name2.length()).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\CSetSwornNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */