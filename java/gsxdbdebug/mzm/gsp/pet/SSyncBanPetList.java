/*    */ package mzm.gsp.pet;
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
/*    */ public class SSyncBanPetList
/*    */   extends __SSyncBanPetList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590660;
/*    */   public LinkedList<Integer> banpetlist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590660;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncBanPetList()
/*    */   {
/* 33 */     this.banpetlist = new LinkedList();
/*    */   }
/*    */   
/*    */   public SSyncBanPetList(LinkedList<Integer> _banpetlist_) {
/* 37 */     this.banpetlist = _banpetlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.banpetlist.size());
/* 46 */     for (Integer _v_ : this.banpetlist) {
/* 47 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 55 */       int _v_ = _os_.unmarshal_int();
/* 56 */       this.banpetlist.add(Integer.valueOf(_v_));
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSyncBanPetList)) {
/* 67 */       SSyncBanPetList _o_ = (SSyncBanPetList)_o1_;
/* 68 */       if (!this.banpetlist.equals(_o_.banpetlist)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.banpetlist.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.banpetlist).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\SSyncBanPetList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */