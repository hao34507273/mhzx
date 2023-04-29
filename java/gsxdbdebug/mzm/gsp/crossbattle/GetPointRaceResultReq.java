/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class GetPointRaceResultReq implements Marshal
/*    */ {
/*    */   public ArrayList<Long> corpsids;
/*    */   public ArrayList<Integer> time_points;
/*    */   
/*    */   public GetPointRaceResultReq()
/*    */   {
/* 15 */     this.corpsids = new ArrayList();
/* 16 */     this.time_points = new ArrayList();
/*    */   }
/*    */   
/*    */   public GetPointRaceResultReq(ArrayList<Long> _corpsids_, ArrayList<Integer> _time_points_) {
/* 20 */     this.corpsids = _corpsids_;
/* 21 */     this.time_points = _time_points_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.compact_uint32(this.corpsids.size());
/* 30 */     for (Long _v_ : this.corpsids) {
/* 31 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 33 */     _os_.compact_uint32(this.time_points.size());
/* 34 */     for (Integer _v_ : this.time_points) {
/* 35 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 43 */       long _v_ = _os_.unmarshal_long();
/* 44 */       this.corpsids.add(Long.valueOf(_v_));
/*    */     }
/* 46 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 48 */       int _v_ = _os_.unmarshal_int();
/* 49 */       this.time_points.add(Integer.valueOf(_v_));
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof GetPointRaceResultReq)) {
/* 57 */       GetPointRaceResultReq _o_ = (GetPointRaceResultReq)_o1_;
/* 58 */       if (!this.corpsids.equals(_o_.corpsids)) return false;
/* 59 */       if (!this.time_points.equals(_o_.time_points)) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.corpsids.hashCode();
/* 68 */     _h_ += this.time_points.hashCode();
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.corpsids).append(",");
/* 76 */     _sb_.append(this.time_points).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetPointRaceResultReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */