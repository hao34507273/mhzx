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
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class JiuXiaoRankRole extends XBean implements xbean.JiuXiaoRankRole
/*     */ {
/*     */   private long roleid;
/*     */   private int layer;
/*     */   private int sec;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.roleid = 0L;
/*  23 */     this.layer = 0;
/*  24 */     this.sec = 0;
/*     */   }
/*     */   
/*     */   JiuXiaoRankRole(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public JiuXiaoRankRole()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public JiuXiaoRankRole(JiuXiaoRankRole _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   JiuXiaoRankRole(xbean.JiuXiaoRankRole _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof JiuXiaoRankRole)) { assign((JiuXiaoRankRole)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(JiuXiaoRankRole _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.roleid = _o_.roleid;
/*  55 */     this.layer = _o_.layer;
/*  56 */     this.sec = _o_.sec;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.roleid = _o_.roleid;
/*  62 */     this.layer = _o_.layer;
/*  63 */     this.sec = _o_.sec;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.roleid);
/*  71 */     _os_.marshal(this.layer);
/*  72 */     _os_.marshal(this.sec);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.roleid = _os_.unmarshal_long();
/*  81 */     this.layer = _os_.unmarshal_int();
/*  82 */     this.sec = _os_.unmarshal_int();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(2, this.layer);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(3, this.sec);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt64(1, this.roleid);
/* 104 */       _output_.writeInt32(2, this.layer);
/* 105 */       _output_.writeInt32(3, this.sec);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           this.roleid = _input_.readInt64();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.layer = _input_.readInt32();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.sec = _input_.readInt32();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 148 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 150 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 159 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 165 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JiuXiaoRankRole copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new JiuXiaoRankRole(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JiuXiaoRankRole toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.JiuXiaoRankRole toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new JiuXiaoRankRole(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JiuXiaoRankRole toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.JiuXiaoRankRole toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLayer()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.layer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSec()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.sec;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogLong(this, JiuXiaoRankRole.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             JiuXiaoRankRole.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLayer(int _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "layer")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogInt(this, JiuXiaoRankRole.this.layer)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             JiuXiaoRankRole.this.layer = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.layer = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSec(int _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "sec")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogInt(this, JiuXiaoRankRole.this.sec)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             JiuXiaoRankRole.this.sec = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.sec = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     JiuXiaoRankRole _o_ = null;
/* 300 */     if ((_o1_ instanceof JiuXiaoRankRole)) { _o_ = (JiuXiaoRankRole)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.roleid != _o_.roleid) return false;
/* 304 */     if (this.layer != _o_.layer) return false;
/* 305 */     if (this.sec != _o_.sec) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ = (int)(_h_ + this.roleid);
/* 315 */     _h_ += this.layer;
/* 316 */     _h_ += this.sec;
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.roleid);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.layer);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.sec);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("roleid"));
/* 340 */     lb.add(new ListenableChanged().setVarName("layer"));
/* 341 */     lb.add(new ListenableChanged().setVarName("sec"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.JiuXiaoRankRole {
/*     */     private Const() {}
/*     */     
/*     */     JiuXiaoRankRole nThis() {
/* 349 */       return JiuXiaoRankRole.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoRankRole copy()
/*     */     {
/* 361 */       return JiuXiaoRankRole.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoRankRole toData()
/*     */     {
/* 367 */       return JiuXiaoRankRole.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.JiuXiaoRankRole toBean()
/*     */     {
/* 372 */       return JiuXiaoRankRole.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoRankRole toDataIf()
/*     */     {
/* 378 */       return JiuXiaoRankRole.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.JiuXiaoRankRole toBeanIf()
/*     */     {
/* 383 */       return JiuXiaoRankRole.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 390 */       JiuXiaoRankRole.this._xdb_verify_unsafe_();
/* 391 */       return JiuXiaoRankRole.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLayer()
/*     */     {
/* 398 */       JiuXiaoRankRole.this._xdb_verify_unsafe_();
/* 399 */       return JiuXiaoRankRole.this.layer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSec()
/*     */     {
/* 406 */       JiuXiaoRankRole.this._xdb_verify_unsafe_();
/* 407 */       return JiuXiaoRankRole.this.sec;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 414 */       JiuXiaoRankRole.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLayer(int _v_)
/*     */     {
/* 422 */       JiuXiaoRankRole.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSec(int _v_)
/*     */     {
/* 430 */       JiuXiaoRankRole.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       JiuXiaoRankRole.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       JiuXiaoRankRole.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return JiuXiaoRankRole.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return JiuXiaoRankRole.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       JiuXiaoRankRole.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return JiuXiaoRankRole.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return JiuXiaoRankRole.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       JiuXiaoRankRole.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return JiuXiaoRankRole.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return JiuXiaoRankRole.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return JiuXiaoRankRole.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return JiuXiaoRankRole.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return JiuXiaoRankRole.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return JiuXiaoRankRole.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return JiuXiaoRankRole.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.JiuXiaoRankRole
/*     */   {
/*     */     private long roleid;
/*     */     
/*     */     private int layer;
/*     */     
/*     */     private int sec;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.JiuXiaoRankRole _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof JiuXiaoRankRole)) { assign((JiuXiaoRankRole)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof JiuXiaoRankRole.Const)) assign(((JiuXiaoRankRole.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(JiuXiaoRankRole _o_) {
/* 558 */       this.roleid = _o_.roleid;
/* 559 */       this.layer = _o_.layer;
/* 560 */       this.sec = _o_.sec;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.roleid = _o_.roleid;
/* 566 */       this.layer = _o_.layer;
/* 567 */       this.sec = _o_.sec;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.roleid);
/* 574 */       _os_.marshal(this.layer);
/* 575 */       _os_.marshal(this.sec);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.roleid = _os_.unmarshal_long();
/* 583 */       this.layer = _os_.unmarshal_int();
/* 584 */       this.sec = _os_.unmarshal_int();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/* 593 */       _size_ += CodedOutputStream.computeInt32Size(2, this.layer);
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(3, this.sec);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt64(1, this.roleid);
/* 604 */         _output_.writeInt32(2, this.layer);
/* 605 */         _output_.writeInt32(3, this.sec);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.roleid = _input_.readInt64();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.layer = _input_.readInt32();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.sec = _input_.readInt32();
/* 643 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 647 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 649 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 658 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 662 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 664 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoRankRole copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoRankRole toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.JiuXiaoRankRole toBean()
/*     */     {
/* 681 */       return new JiuXiaoRankRole(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoRankRole toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.JiuXiaoRankRole toBeanIf()
/*     */     {
/* 692 */       return new JiuXiaoRankRole(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 718 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 729 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLayer()
/*     */     {
/* 736 */       return this.layer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSec()
/*     */     {
/* 743 */       return this.sec;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 750 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLayer(int _v_)
/*     */     {
/* 757 */       this.layer = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSec(int _v_)
/*     */     {
/* 764 */       this.sec = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.roleid != _o_.roleid) return false;
/* 773 */       if (this.layer != _o_.layer) return false;
/* 774 */       if (this.sec != _o_.sec) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ = (int)(_h_ + this.roleid);
/* 783 */       _h_ += this.layer;
/* 784 */       _h_ += this.sec;
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.roleid);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.layer);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.sec);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\JiuXiaoRankRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */