/*    */ package mzm.gsp.partner;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class LineUp implements Marshal
/*    */ {
/*    */   public ArrayList<Integer> positions;
/*    */   public int zhenfaid;
/*    */   
/*    */   public LineUp()
/*    */   {
/* 15 */     this.positions = new ArrayList();
/*    */   }
/*    */   
/*    */   public LineUp(ArrayList<Integer> _positions_, int _zhenfaid_) {
/* 19 */     this.positions = _positions_;
/* 20 */     this.zhenfaid = _zhenfaid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.compact_uint32(this.positions.size());
/* 29 */     for (Integer _v_ : this.positions) {
/* 30 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 32 */     _os_.marshal(this.zhenfaid);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 39 */       int _v_ = _os_.unmarshal_int();
/* 40 */       this.positions.add(Integer.valueOf(_v_));
/*    */     }
/* 42 */     this.zhenfaid = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof LineUp)) {
/* 49 */       LineUp _o_ = (LineUp)_o1_;
/* 50 */       if (!this.positions.equals(_o_.positions)) return false;
/* 51 */       if (this.zhenfaid != _o_.zhenfaid) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.positions.hashCode();
/* 60 */     _h_ += this.zhenfaid;
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.positions).append(",");
/* 68 */     _sb_.append(this.zhenfaid).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\LineUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */