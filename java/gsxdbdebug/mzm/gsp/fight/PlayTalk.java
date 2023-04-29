/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class PlayTalk implements Marshal
/*    */ {
/*    */   public int fighterid;
/*    */   public int strid;
/*    */   public ArrayList<String> args;
/*    */   
/*    */   public PlayTalk()
/*    */   {
/* 16 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public PlayTalk(int _fighterid_, int _strid_, ArrayList<String> _args_) {
/* 20 */     this.fighterid = _fighterid_;
/* 21 */     this.strid = _strid_;
/* 22 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.fighterid);
/* 31 */     _os_.marshal(this.strid);
/* 32 */     _os_.compact_uint32(this.args.size());
/* 33 */     for (String _v_ : this.args) {
/* 34 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.fighterid = _os_.unmarshal_int();
/* 41 */     this.strid = _os_.unmarshal_int();
/* 42 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 44 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 45 */       this.args.add(_v_);
/*    */     }
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof PlayTalk)) {
/* 53 */       PlayTalk _o_ = (PlayTalk)_o1_;
/* 54 */       if (this.fighterid != _o_.fighterid) return false;
/* 55 */       if (this.strid != _o_.strid) return false;
/* 56 */       if (!this.args.equals(_o_.args)) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.fighterid;
/* 65 */     _h_ += this.strid;
/* 66 */     _h_ += this.args.hashCode();
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.fighterid).append(",");
/* 74 */     _sb_.append(this.strid).append(",");
/* 75 */     _sb_.append(this.args).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlayTalk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */