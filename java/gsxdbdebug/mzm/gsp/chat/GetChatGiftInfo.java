/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GetChatGiftInfo
/*    */   implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String rolename;
/*    */   public int moneynum;
/*    */   
/*    */   public GetChatGiftInfo()
/*    */   {
/* 16 */     this.rolename = "";
/*    */   }
/*    */   
/*    */   public GetChatGiftInfo(long _roleid_, String _rolename_, int _moneynum_) {
/* 20 */     this.roleid = _roleid_;
/* 21 */     this.rolename = _rolename_;
/* 22 */     this.moneynum = _moneynum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.roleid);
/* 31 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 32 */     _os_.marshal(this.moneynum);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.roleid = _os_.unmarshal_long();
/* 38 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 39 */     this.moneynum = _os_.unmarshal_int();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof GetChatGiftInfo)) {
/* 46 */       GetChatGiftInfo _o_ = (GetChatGiftInfo)_o1_;
/* 47 */       if (this.roleid != _o_.roleid) return false;
/* 48 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 49 */       if (this.moneynum != _o_.moneynum) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += (int)this.roleid;
/* 58 */     _h_ += this.rolename.hashCode();
/* 59 */     _h_ += this.moneynum;
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.roleid).append(",");
/* 67 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 68 */     _sb_.append(this.moneynum).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\GetChatGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */