/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class GetPointRaceDataReq implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public int from;
/*    */   public int to;
/*    */   public int index;
/*    */   public ArrayList<Integer> time_points;
/*    */   
/*    */   public GetPointRaceDataReq()
/*    */   {
/* 18 */     this.time_points = new ArrayList();
/*    */   }
/*    */   
/*    */   public GetPointRaceDataReq(long _roleid_, int _from_, int _to_, int _index_, ArrayList<Integer> _time_points_) {
/* 22 */     this.roleid = _roleid_;
/* 23 */     this.from = _from_;
/* 24 */     this.to = _to_;
/* 25 */     this.index = _index_;
/* 26 */     this.time_points = _time_points_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.roleid);
/* 35 */     _os_.marshal(this.from);
/* 36 */     _os_.marshal(this.to);
/* 37 */     _os_.marshal(this.index);
/* 38 */     _os_.compact_uint32(this.time_points.size());
/* 39 */     for (Integer _v_ : this.time_points) {
/* 40 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     this.roleid = _os_.unmarshal_long();
/* 47 */     this.from = _os_.unmarshal_int();
/* 48 */     this.to = _os_.unmarshal_int();
/* 49 */     this.index = _os_.unmarshal_int();
/* 50 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 52 */       int _v_ = _os_.unmarshal_int();
/* 53 */       this.time_points.add(Integer.valueOf(_v_));
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof GetPointRaceDataReq)) {
/* 61 */       GetPointRaceDataReq _o_ = (GetPointRaceDataReq)_o1_;
/* 62 */       if (this.roleid != _o_.roleid) return false;
/* 63 */       if (this.from != _o_.from) return false;
/* 64 */       if (this.to != _o_.to) return false;
/* 65 */       if (this.index != _o_.index) return false;
/* 66 */       if (!this.time_points.equals(_o_.time_points)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += (int)this.roleid;
/* 75 */     _h_ += this.from;
/* 76 */     _h_ += this.to;
/* 77 */     _h_ += this.index;
/* 78 */     _h_ += this.time_points.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.roleid).append(",");
/* 86 */     _sb_.append(this.from).append(",");
/* 87 */     _sb_.append(this.to).append(",");
/* 88 */     _sb_.append(this.index).append(",");
/* 89 */     _sb_.append(this.time_points).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetPointRaceDataReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */