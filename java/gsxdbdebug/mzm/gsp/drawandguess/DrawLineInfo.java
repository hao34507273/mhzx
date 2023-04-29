/*    */ package mzm.gsp.drawandguess;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class DrawLineInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int line_id;
/*    */   public int action_id;
/*    */   public byte color;
/*    */   public byte size;
/*    */   public ArrayList<PointInfo> point_list;
/*    */   
/*    */   public DrawLineInfo()
/*    */   {
/* 16 */     this.point_list = new ArrayList();
/*    */   }
/*    */   
/*    */   public DrawLineInfo(int _line_id_, int _action_id_, byte _color_, byte _size_, ArrayList<PointInfo> _point_list_) {
/* 20 */     this.line_id = _line_id_;
/* 21 */     this.action_id = _action_id_;
/* 22 */     this.color = _color_;
/* 23 */     this.size = _size_;
/* 24 */     this.point_list = _point_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     for (PointInfo _v_ : this.point_list)
/* 29 */       if (!_v_._validator_()) return false;
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.line_id);
/* 35 */     _os_.marshal(this.action_id);
/* 36 */     _os_.marshal(this.color);
/* 37 */     _os_.marshal(this.size);
/* 38 */     _os_.compact_uint32(this.point_list.size());
/* 39 */     for (PointInfo _v_ : this.point_list) {
/* 40 */       _os_.marshal(_v_);
/*    */     }
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 46 */     this.line_id = _os_.unmarshal_int();
/* 47 */     this.action_id = _os_.unmarshal_int();
/* 48 */     this.color = _os_.unmarshal_byte();
/* 49 */     this.size = _os_.unmarshal_byte();
/* 50 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 51 */       PointInfo _v_ = new PointInfo();
/* 52 */       _v_.unmarshal(_os_);
/* 53 */       this.point_list.add(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof DrawLineInfo)) {
/* 61 */       DrawLineInfo _o_ = (DrawLineInfo)_o1_;
/* 62 */       if (this.line_id != _o_.line_id) return false;
/* 63 */       if (this.action_id != _o_.action_id) return false;
/* 64 */       if (this.color != _o_.color) return false;
/* 65 */       if (this.size != _o_.size) return false;
/* 66 */       if (!this.point_list.equals(_o_.point_list)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.line_id;
/* 75 */     _h_ += this.action_id;
/* 76 */     _h_ += this.color;
/* 77 */     _h_ += this.size;
/* 78 */     _h_ += this.point_list.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.line_id).append(",");
/* 86 */     _sb_.append(this.action_id).append(",");
/* 87 */     _sb_.append(this.color).append(",");
/* 88 */     _sb_.append(this.size).append(",");
/* 89 */     _sb_.append(this.point_list).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\DrawLineInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */