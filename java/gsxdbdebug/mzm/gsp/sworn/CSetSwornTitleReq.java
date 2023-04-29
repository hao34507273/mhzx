/*    */ package mzm.gsp.sworn;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.sworn.main.PSetSwornTitleReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSetSwornTitleReq
/*    */   extends __CSetSwornTitleReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12597762;
/*    */   public long swornid;
/*    */   public String title;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PSetSwornTitleReq(roleid, this.swornid, this.title));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12597762;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CSetSwornTitleReq()
/*    */   {
/* 36 */     this.title = "";
/*    */   }
/*    */   
/*    */   public CSetSwornTitleReq(long _swornid_, String _title_) {
/* 40 */     this.swornid = _swornid_;
/* 41 */     this.title = _title_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.swornid);
/* 50 */     _os_.marshal(this.title, "UTF-16LE");
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.swornid = _os_.unmarshal_long();
/* 56 */     this.title = _os_.unmarshal_String("UTF-16LE");
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CSetSwornTitleReq)) {
/* 66 */       CSetSwornTitleReq _o_ = (CSetSwornTitleReq)_o1_;
/* 67 */       if (this.swornid != _o_.swornid) return false;
/* 68 */       if (!this.title.equals(_o_.title)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += (int)this.swornid;
/* 77 */     _h_ += this.title.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.swornid).append(",");
/* 85 */     _sb_.append("T").append(this.title.length()).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\CSetSwornTitleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */