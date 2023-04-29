/*    */ package mzm.gsp.question;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class PictureInfo implements Marshal
/*    */ {
/*    */   public ArrayList<Integer> resourcelist;
/*    */   public ArrayList<AllMoveSteps> movepath;
/*    */   public int difficultylevelid;
/*    */   
/*    */   public PictureInfo()
/*    */   {
/* 16 */     this.resourcelist = new ArrayList();
/* 17 */     this.movepath = new ArrayList();
/*    */   }
/*    */   
/*    */   public PictureInfo(ArrayList<Integer> _resourcelist_, ArrayList<AllMoveSteps> _movepath_, int _difficultylevelid_) {
/* 21 */     this.resourcelist = _resourcelist_;
/* 22 */     this.movepath = _movepath_;
/* 23 */     this.difficultylevelid = _difficultylevelid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     for (AllMoveSteps _v_ : this.movepath)
/* 28 */       if (!_v_._validator_()) return false;
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.compact_uint32(this.resourcelist.size());
/* 34 */     for (Integer _v_ : this.resourcelist) {
/* 35 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 37 */     _os_.compact_uint32(this.movepath.size());
/* 38 */     for (AllMoveSteps _v_ : this.movepath) {
/* 39 */       _os_.marshal(_v_);
/*    */     }
/* 41 */     _os_.marshal(this.difficultylevelid);
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 48 */       int _v_ = _os_.unmarshal_int();
/* 49 */       this.resourcelist.add(Integer.valueOf(_v_));
/*    */     }
/* 51 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 52 */       AllMoveSteps _v_ = new AllMoveSteps();
/* 53 */       _v_.unmarshal(_os_);
/* 54 */       this.movepath.add(_v_);
/*    */     }
/* 56 */     this.difficultylevelid = _os_.unmarshal_int();
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof PictureInfo)) {
/* 63 */       PictureInfo _o_ = (PictureInfo)_o1_;
/* 64 */       if (!this.resourcelist.equals(_o_.resourcelist)) return false;
/* 65 */       if (!this.movepath.equals(_o_.movepath)) return false;
/* 66 */       if (this.difficultylevelid != _o_.difficultylevelid) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.resourcelist.hashCode();
/* 75 */     _h_ += this.movepath.hashCode();
/* 76 */     _h_ += this.difficultylevelid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.resourcelist).append(",");
/* 84 */     _sb_.append(this.movepath).append(",");
/* 85 */     _sb_.append(this.difficultylevelid).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\PictureInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */