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
/*    */ 
/*    */ 
/*    */ public class SBuyGoldUseInGotRes
/*    */   extends __SBuyGoldUseInGotRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584843;
/*    */   public int ingotnum;
/*    */   public int buygoldnum;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584843;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SBuyGoldUseInGotRes() {}
/*    */   
/*    */ 
/*    */   public SBuyGoldUseInGotRes(int _ingotnum_, int _buygoldnum_)
/*    */   {
/* 35 */     this.ingotnum = _ingotnum_;
/* 36 */     this.buygoldnum = _buygoldnum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.ingotnum);
/* 45 */     _os_.marshal(this.buygoldnum);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.ingotnum = _os_.unmarshal_int();
/* 51 */     this.buygoldnum = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SBuyGoldUseInGotRes)) {
/* 61 */       SBuyGoldUseInGotRes _o_ = (SBuyGoldUseInGotRes)_o1_;
/* 62 */       if (this.ingotnum != _o_.ingotnum) return false;
/* 63 */       if (this.buygoldnum != _o_.buygoldnum) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.ingotnum;
/* 72 */     _h_ += this.buygoldnum;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.ingotnum).append(",");
/* 80 */     _sb_.append(this.buygoldnum).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBuyGoldUseInGotRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.ingotnum - _o_.ingotnum;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.buygoldnum - _o_.buygoldnum;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SBuyGoldUseInGotRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */