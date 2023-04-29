/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class BanGraphData implements Marshal
/*    */ {
/*    */   public HashSet<Integer> graphids;
/*    */   
/*    */   public BanGraphData()
/*    */   {
/* 14 */     this.graphids = new HashSet();
/*    */   }
/*    */   
/*    */   public BanGraphData(HashSet<Integer> _graphids_) {
/* 18 */     this.graphids = _graphids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.graphids.size());
/* 27 */     for (Integer _v_ : this.graphids) {
/* 28 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 36 */       int _v_ = _os_.unmarshal_int();
/* 37 */       this.graphids.add(Integer.valueOf(_v_));
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof BanGraphData)) {
/* 45 */       BanGraphData _o_ = (BanGraphData)_o1_;
/* 46 */       if (!this.graphids.equals(_o_.graphids)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.graphids.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.graphids).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\BanGraphData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */