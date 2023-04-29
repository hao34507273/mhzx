/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class CourseStudyInfo extends XBean implements xbean.CourseStudyInfo
/*     */ {
/*     */   private int course_type;
/*     */   private long time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.course_type = 0;
/*  21 */     this.time = 0L;
/*     */   }
/*     */   
/*     */   CourseStudyInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public CourseStudyInfo()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CourseStudyInfo(CourseStudyInfo _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CourseStudyInfo(xbean.CourseStudyInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof CourseStudyInfo)) { assign((CourseStudyInfo)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CourseStudyInfo _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.course_type = _o_.course_type;
/*  52 */     this.time = _o_.time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.course_type = _o_.course_type;
/*  58 */     this.time = _o_.time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.course_type);
/*  66 */     _os_.marshal(this.time);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.course_type = _os_.unmarshal_int();
/*  75 */     this.time = _os_.unmarshal_long();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt32Size(1, this.course_type);
/*  85 */     _size_ += CodedOutputStream.computeInt64Size(2, this.time);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt32(1, this.course_type);
/*  96 */       _output_.writeInt64(2, this.time);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 100 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 102 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       boolean done = false;
/* 112 */       while (!done)
/*     */       {
/* 114 */         int tag = _input_.readTag();
/* 115 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 119 */           done = true;
/* 120 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 124 */           this.course_type = _input_.readInt32();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.time = _input_.readInt64();
/* 130 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 134 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 136 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 145 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 151 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CourseStudyInfo copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new CourseStudyInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CourseStudyInfo toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CourseStudyInfo toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new CourseStudyInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CourseStudyInfo toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CourseStudyInfo toBeanIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCourse_type()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.course_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTime()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCourse_type(int _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "course_type")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new xdb.logs.LogInt(this, CourseStudyInfo.this.course_type)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             CourseStudyInfo.this.course_type = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.course_type = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTime(long _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new xdb.logs.LogLong(this, CourseStudyInfo.this.time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             CourseStudyInfo.this.time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     CourseStudyInfo _o_ = null;
/* 257 */     if ((_o1_ instanceof CourseStudyInfo)) { _o_ = (CourseStudyInfo)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.course_type != _o_.course_type) return false;
/* 261 */     if (this.time != _o_.time) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ += this.course_type;
/* 271 */     _h_ = (int)(_h_ + this.time);
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.course_type);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.time);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     ListenableBean lb = new ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("course_type"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("time"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CourseStudyInfo {
/*     */     private Const() {}
/*     */     
/*     */     CourseStudyInfo nThis() {
/* 301 */       return CourseStudyInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CourseStudyInfo copy()
/*     */     {
/* 313 */       return CourseStudyInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CourseStudyInfo toData()
/*     */     {
/* 319 */       return CourseStudyInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CourseStudyInfo toBean()
/*     */     {
/* 324 */       return CourseStudyInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CourseStudyInfo toDataIf()
/*     */     {
/* 330 */       return CourseStudyInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CourseStudyInfo toBeanIf()
/*     */     {
/* 335 */       return CourseStudyInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCourse_type()
/*     */     {
/* 342 */       CourseStudyInfo.this._xdb_verify_unsafe_();
/* 343 */       return CourseStudyInfo.this.course_type;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTime()
/*     */     {
/* 350 */       CourseStudyInfo.this._xdb_verify_unsafe_();
/* 351 */       return CourseStudyInfo.this.time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCourse_type(int _v_)
/*     */     {
/* 358 */       CourseStudyInfo.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTime(long _v_)
/*     */     {
/* 366 */       CourseStudyInfo.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       CourseStudyInfo.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       CourseStudyInfo.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return CourseStudyInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return CourseStudyInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       CourseStudyInfo.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return CourseStudyInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return CourseStudyInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       CourseStudyInfo.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return CourseStudyInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return CourseStudyInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return CourseStudyInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return CourseStudyInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return CourseStudyInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return CourseStudyInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return CourseStudyInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CourseStudyInfo
/*     */   {
/*     */     private int course_type;
/*     */     
/*     */     private long time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.CourseStudyInfo _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof CourseStudyInfo)) { assign((CourseStudyInfo)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof CourseStudyInfo.Const)) assign(((CourseStudyInfo.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CourseStudyInfo _o_) {
/* 492 */       this.course_type = _o_.course_type;
/* 493 */       this.time = _o_.time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.course_type = _o_.course_type;
/* 499 */       this.time = _o_.time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.course_type);
/* 506 */       _os_.marshal(this.time);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.course_type = _os_.unmarshal_int();
/* 514 */       this.time = _os_.unmarshal_long();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt32Size(1, this.course_type);
/* 523 */       _size_ += CodedOutputStream.computeInt64Size(2, this.time);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt32(1, this.course_type);
/* 533 */         _output_.writeInt64(2, this.time);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 537 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 539 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 547 */         boolean done = false;
/* 548 */         while (!done)
/*     */         {
/* 550 */           int tag = _input_.readTag();
/* 551 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 555 */             done = true;
/* 556 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 560 */             this.course_type = _input_.readInt32();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.time = _input_.readInt64();
/* 566 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 570 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 572 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 581 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 585 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 587 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CourseStudyInfo copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CourseStudyInfo toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CourseStudyInfo toBean()
/*     */     {
/* 604 */       return new CourseStudyInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CourseStudyInfo toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CourseStudyInfo toBeanIf()
/*     */     {
/* 615 */       return new CourseStudyInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 641 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 645 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCourse_type()
/*     */     {
/* 652 */       return this.course_type;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTime()
/*     */     {
/* 659 */       return this.time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCourse_type(int _v_)
/*     */     {
/* 666 */       this.course_type = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTime(long _v_)
/*     */     {
/* 673 */       this.time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.course_type != _o_.course_type) return false;
/* 682 */       if (this.time != _o_.time) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ += this.course_type;
/* 691 */       _h_ = (int)(_h_ + this.time);
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.course_type);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.time);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CourseStudyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */