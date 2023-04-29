/*    */ package mzm.gsp.shanghui;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncBanShopingList
/*    */   extends __SSyncBanShopingList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592652;
/*    */   public LinkedList<Integer> banitemlist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12592652;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncBanShopingList()
/*    */   {
/* 33 */     this.banitemlist = new LinkedList();
/*    */   }
/*    */   
/*    */   public SSyncBanShopingList(LinkedList<Integer> _banitemlist_) {
/* 37 */     this.banitemlist = _banitemlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.banitemlist.size());
/* 46 */     for (Integer _v_ : this.banitemlist) {
/* 47 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 55 */       int _v_ = _os_.unmarshal_int();
/* 56 */       this.banitemlist.add(Integer.valueOf(_v_));
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSyncBanShopingList)) {
/* 67 */       SSyncBanShopingList _o_ = (SSyncBanShopingList)_o1_;
/* 68 */       if (!this.banitemlist.equals(_o_.banitemlist)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.banitemlist.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.banitemlist).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\SSyncBanShopingList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */