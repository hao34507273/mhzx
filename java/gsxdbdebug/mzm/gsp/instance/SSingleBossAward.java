/*    */ package mzm.gsp.instance;
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
/*    */ public class SSingleBossAward
/*    */   extends __SSingleBossAward__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591385;
/*    */   public ArrayList<Item2Count> items;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591385;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSingleBossAward()
/*    */   {
/* 33 */     this.items = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSingleBossAward(ArrayList<Item2Count> _items_) {
/* 37 */     this.items = _items_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (Item2Count _v_ : this.items)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.items.size());
/* 48 */     for (Item2Count _v_ : this.items) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       Item2Count _v_ = new Item2Count();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.items.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSingleBossAward)) {
/* 69 */       SSingleBossAward _o_ = (SSingleBossAward)_o1_;
/* 70 */       if (!this.items.equals(_o_.items)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.items.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.items).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\SSingleBossAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */