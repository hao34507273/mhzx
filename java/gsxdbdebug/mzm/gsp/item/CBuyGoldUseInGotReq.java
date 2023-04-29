/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PBuyGoldUseIngot;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CBuyGoldUseInGotReq
/*    */   extends __CBuyGoldUseInGotReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584842;
/*    */   public int ingotnum;
/*    */   public long clientingotnum;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PBuyGoldUseIngot(roleid, this.ingotnum, this.clientingotnum));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12584842;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CBuyGoldUseInGotReq() {}
/*    */   
/*    */ 
/*    */   public CBuyGoldUseInGotReq(int _ingotnum_, long _clientingotnum_)
/*    */   {
/* 40 */     this.ingotnum = _ingotnum_;
/* 41 */     this.clientingotnum = _clientingotnum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.ingotnum);
/* 50 */     _os_.marshal(this.clientingotnum);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.ingotnum = _os_.unmarshal_int();
/* 56 */     this.clientingotnum = _os_.unmarshal_long();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CBuyGoldUseInGotReq)) {
/* 66 */       CBuyGoldUseInGotReq _o_ = (CBuyGoldUseInGotReq)_o1_;
/* 67 */       if (this.ingotnum != _o_.ingotnum) return false;
/* 68 */       if (this.clientingotnum != _o_.clientingotnum) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.ingotnum;
/* 77 */     _h_ += (int)this.clientingotnum;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.ingotnum).append(",");
/* 85 */     _sb_.append(this.clientingotnum).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CBuyGoldUseInGotReq _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.ingotnum - _o_.ingotnum;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = Long.signum(this.clientingotnum - _o_.clientingotnum);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CBuyGoldUseInGotReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */