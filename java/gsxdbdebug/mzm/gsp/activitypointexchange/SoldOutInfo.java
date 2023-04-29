/*    */ package mzm.gsp.activitypointexchange;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class SoldOutInfo implements Marshal
/*    */ {
/*    */   public ArrayList<Integer> goodscfgids;
/*    */   
/*    */   public SoldOutInfo()
/*    */   {
/* 14 */     this.goodscfgids = new ArrayList();
/*    */   }
/*    */   
/*    */   public SoldOutInfo(ArrayList<Integer> _goodscfgids_) {
/* 18 */     this.goodscfgids = _goodscfgids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.goodscfgids.size());
/* 27 */     for (Integer _v_ : this.goodscfgids) {
/* 28 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 36 */       int _v_ = _os_.unmarshal_int();
/* 37 */       this.goodscfgids.add(Integer.valueOf(_v_));
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof SoldOutInfo)) {
/* 45 */       SoldOutInfo _o_ = (SoldOutInfo)_o1_;
/* 46 */       if (!this.goodscfgids.equals(_o_.goodscfgids)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.goodscfgids.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.goodscfgids).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\SoldOutInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */