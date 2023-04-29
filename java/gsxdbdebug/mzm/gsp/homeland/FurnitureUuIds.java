/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class FurnitureUuIds implements Marshal
/*    */ {
/*    */   public HashSet<Long> uuids;
/*    */   
/*    */   public FurnitureUuIds()
/*    */   {
/* 14 */     this.uuids = new HashSet();
/*    */   }
/*    */   
/*    */   public FurnitureUuIds(HashSet<Long> _uuids_) {
/* 18 */     this.uuids = _uuids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.uuids.size());
/* 27 */     for (Long _v_ : this.uuids) {
/* 28 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 36 */       long _v_ = _os_.unmarshal_long();
/* 37 */       this.uuids.add(Long.valueOf(_v_));
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof FurnitureUuIds)) {
/* 45 */       FurnitureUuIds _o_ = (FurnitureUuIds)_o1_;
/* 46 */       if (!this.uuids.equals(_o_.uuids)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.uuids.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.uuids).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\FurnitureUuIds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */