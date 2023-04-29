/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class SQYXTExtraAwardRes
/*    */   extends __SQYXTExtraAwardRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594749;
/*    */   public ArrayList<Item2Count> item2countlist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594749;
/*    */   }
/*    */   
/*    */ 
/*    */   public SQYXTExtraAwardRes()
/*    */   {
/* 33 */     this.item2countlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SQYXTExtraAwardRes(ArrayList<Item2Count> _item2countlist_) {
/* 37 */     this.item2countlist = _item2countlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (Item2Count _v_ : this.item2countlist)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.item2countlist.size());
/* 48 */     for (Item2Count _v_ : this.item2countlist) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       Item2Count _v_ = new Item2Count();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.item2countlist.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SQYXTExtraAwardRes)) {
/* 69 */       SQYXTExtraAwardRes _o_ = (SQYXTExtraAwardRes)_o1_;
/* 70 */       if (!this.item2countlist.equals(_o_.item2countlist)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.item2countlist.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.item2countlist).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\SQYXTExtraAwardRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */