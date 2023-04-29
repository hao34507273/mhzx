/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class FightCmd extends XBean implements xbean.FightCmd
/*     */ {
/*     */   private int fighterid;
/*     */   private int op_type;
/*     */   private byte[] content;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.fighterid = 0;
/*  23 */     this.op_type = 0;
/*  24 */     this.content = new byte[0];
/*     */   }
/*     */   
/*     */   FightCmd(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.content = new byte[0];
/*     */   }
/*     */   
/*     */   public FightCmd()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FightCmd(FightCmd _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FightCmd(xbean.FightCmd _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof FightCmd)) { assign((FightCmd)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FightCmd _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.fighterid = _o_.fighterid;
/*  56 */     this.op_type = _o_.op_type;
/*  57 */     this.content = Arrays.copyOf(_o_.content, _o_.content.length);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.fighterid = _o_.fighterid;
/*  63 */     this.op_type = _o_.op_type;
/*  64 */     this.content = Arrays.copyOf(_o_.content, _o_.content.length);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.fighterid);
/*  72 */     _os_.marshal(this.op_type);
/*  73 */     _os_.marshal(this.content);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.fighterid = _os_.unmarshal_int();
/*  82 */     this.op_type = _os_.unmarshal_int();
/*  83 */     this.content = _os_.unmarshal_bytes();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(1, this.fighterid);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(2, this.op_type);
/*  94 */     _size_ += CodedOutputStream.computeByteArraySize(3, this.content);
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       _output_.writeInt32(1, this.fighterid);
/* 105 */       _output_.writeInt32(2, this.op_type);
/* 106 */       _output_.writeByteArray(3, this.content);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 110 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 112 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 121 */       boolean done = false;
/* 122 */       while (!done)
/*     */       {
/* 124 */         int tag = _input_.readTag();
/* 125 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 129 */           done = true;
/* 130 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 134 */           this.fighterid = _input_.readInt32();
/* 135 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 139 */           this.op_type = _input_.readInt32();
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 144 */           this.content = _input_.readByteArray();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 149 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 151 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 160 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCmd copy()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new FightCmd(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCmd toData()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightCmd toBean()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new FightCmd(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCmd toDataIf()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightCmd toBeanIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getFighterid()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this.fighterid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getOp_type()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return this.op_type;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public <T extends Marshal> T getContent(T _v_)
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 232 */       _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.content)));
/* 233 */       return _v_;
/*     */     }
/*     */     catch (MarshalException _e_)
/*     */     {
/* 237 */       throw new xio.MarshalError();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isContentEmpty()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return this.content.length == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public byte[] getContentCopy()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return Arrays.copyOf(this.content, this.content.length);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFighterid(int _v_)
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     xdb.Logs.logIf(new LogKey(this, "fighterid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 266 */         new xdb.logs.LogInt(this, FightCmd.this.fighterid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 270 */             FightCmd.this.fighterid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 274 */     });
/* 275 */     this.fighterid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOp_type(int _v_)
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     xdb.Logs.logIf(new LogKey(this, "op_type")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 287 */         new xdb.logs.LogInt(this, FightCmd.this.op_type)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 291 */             FightCmd.this.op_type = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 295 */     });
/* 296 */     this.op_type = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContent(Marshal _v_)
/*     */   {
/* 303 */     _xdb_verify_unsafe_();
/* 304 */     xdb.Logs.logIf(new LogKey(this, "content")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 308 */         new xdb.logs.LogObject(this, FightCmd.this.content)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 312 */             FightCmd.this.content = ((byte[])this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 316 */     });
/* 317 */     this.content = _v_.marshal(new OctetsStream()).getBytes();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContentCopy(byte[] _v_)
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     xdb.Logs.logIf(new LogKey(this, "content")
/*     */     {
/*     */       protected xdb.Log create() {
/* 328 */         new xdb.logs.LogObject(this, FightCmd.this.content)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 332 */             FightCmd.this.content = ((byte[])this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 336 */     });
/* 337 */     this.content = Arrays.copyOf(_v_, _v_.length);
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     FightCmd _o_ = null;
/* 345 */     if ((_o1_ instanceof FightCmd)) { _o_ = (FightCmd)_o1_;
/* 346 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 347 */       return false;
/* 348 */     if (this.fighterid != _o_.fighterid) return false;
/* 349 */     if (this.op_type != _o_.op_type) return false;
/* 350 */     if (!Arrays.equals(this.content, _o_.content)) return false;
/* 351 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 357 */     _xdb_verify_unsafe_();
/* 358 */     int _h_ = 0;
/* 359 */     _h_ += this.fighterid;
/* 360 */     _h_ += this.op_type;
/* 361 */     _h_ += Arrays.hashCode(this.content);
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.fighterid);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.op_type);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append('B').append(this.content.length);
/* 376 */     _sb_.append(")");
/* 377 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 383 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 384 */     lb.add(new xdb.logs.ListenableChanged().setVarName("fighterid"));
/* 385 */     lb.add(new xdb.logs.ListenableChanged().setVarName("op_type"));
/* 386 */     lb.add(new xdb.logs.ListenableChanged().setVarName("content"));
/* 387 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FightCmd {
/*     */     private Const() {}
/*     */     
/*     */     FightCmd nThis() {
/* 394 */       return FightCmd.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCmd copy()
/*     */     {
/* 406 */       return FightCmd.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCmd toData()
/*     */     {
/* 412 */       return FightCmd.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FightCmd toBean()
/*     */     {
/* 417 */       return FightCmd.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCmd toDataIf()
/*     */     {
/* 423 */       return FightCmd.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FightCmd toBeanIf()
/*     */     {
/* 428 */       return FightCmd.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFighterid()
/*     */     {
/* 435 */       FightCmd.this._xdb_verify_unsafe_();
/* 436 */       return FightCmd.this.fighterid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getOp_type()
/*     */     {
/* 443 */       FightCmd.this._xdb_verify_unsafe_();
/* 444 */       return FightCmd.this.op_type;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public <T extends Marshal> T getContent(T _v_)
/*     */     {
/* 451 */       FightCmd.this._xdb_verify_unsafe_();
/* 452 */       return FightCmd.this.getContent(_v_);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isContentEmpty()
/*     */     {
/* 459 */       FightCmd.this._xdb_verify_unsafe_();
/* 460 */       return FightCmd.this.isContentEmpty();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public byte[] getContentCopy()
/*     */     {
/* 467 */       FightCmd.this._xdb_verify_unsafe_();
/* 468 */       return FightCmd.this.getContentCopy();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFighterid(int _v_)
/*     */     {
/* 475 */       FightCmd.this._xdb_verify_unsafe_();
/* 476 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOp_type(int _v_)
/*     */     {
/* 483 */       FightCmd.this._xdb_verify_unsafe_();
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContent(Marshal _v_)
/*     */     {
/* 491 */       FightCmd.this._xdb_verify_unsafe_();
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContentCopy(byte[] _v_)
/*     */     {
/* 499 */       FightCmd.this._xdb_verify_unsafe_();
/* 500 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 506 */       FightCmd.this._xdb_verify_unsafe_();
/* 507 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 513 */       FightCmd.this._xdb_verify_unsafe_();
/* 514 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 520 */       return FightCmd.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 526 */       return FightCmd.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws MarshalException
/*     */     {
/* 532 */       FightCmd.this._xdb_verify_unsafe_();
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 539 */       return FightCmd.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 545 */       return FightCmd.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 551 */       FightCmd.this._xdb_verify_unsafe_();
/* 552 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 558 */       return FightCmd.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 564 */       return FightCmd.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 570 */       return FightCmd.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 576 */       return FightCmd.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 582 */       return FightCmd.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 588 */       return FightCmd.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 594 */       return FightCmd.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FightCmd
/*     */   {
/*     */     private int fighterid;
/*     */     
/*     */     private int op_type;
/*     */     
/*     */     private byte[] content;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 610 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 615 */       this.content = new byte[0];
/*     */     }
/*     */     
/*     */     Data(xbean.FightCmd _o1_)
/*     */     {
/* 620 */       if ((_o1_ instanceof FightCmd)) { assign((FightCmd)_o1_);
/* 621 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 622 */       } else if ((_o1_ instanceof FightCmd.Const)) assign(((FightCmd.Const)_o1_).nThis()); else {
/* 623 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FightCmd _o_) {
/* 628 */       this.fighterid = _o_.fighterid;
/* 629 */       this.op_type = _o_.op_type;
/* 630 */       this.content = Arrays.copyOf(_o_.content, _o_.content.length);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 635 */       this.fighterid = _o_.fighterid;
/* 636 */       this.op_type = _o_.op_type;
/* 637 */       this.content = Arrays.copyOf(_o_.content, _o_.content.length);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 643 */       _os_.marshal(this.fighterid);
/* 644 */       _os_.marshal(this.op_type);
/* 645 */       _os_.marshal(this.content);
/* 646 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws MarshalException
/*     */     {
/* 652 */       this.fighterid = _os_.unmarshal_int();
/* 653 */       this.op_type = _os_.unmarshal_int();
/* 654 */       this.content = _os_.unmarshal_bytes();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.fighterid);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.op_type);
/* 664 */       _size_ += CodedOutputStream.computeByteArraySize(3, this.content);
/* 665 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 673 */         _output_.writeInt32(1, this.fighterid);
/* 674 */         _output_.writeInt32(2, this.op_type);
/* 675 */         _output_.writeByteArray(3, this.content);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 679 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 681 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 689 */         boolean done = false;
/* 690 */         while (!done)
/*     */         {
/* 692 */           int tag = _input_.readTag();
/* 693 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 697 */             done = true;
/* 698 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 702 */             this.fighterid = _input_.readInt32();
/* 703 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 707 */             this.op_type = _input_.readInt32();
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 712 */             this.content = _input_.readByteArray();
/* 713 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 717 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 719 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 728 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 732 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 734 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCmd copy()
/*     */     {
/* 740 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCmd toData()
/*     */     {
/* 746 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FightCmd toBean()
/*     */     {
/* 751 */       return new FightCmd(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCmd toDataIf()
/*     */     {
/* 757 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FightCmd toBeanIf()
/*     */     {
/* 762 */       return new FightCmd(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 768 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 772 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 776 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 780 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 784 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 788 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 792 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFighterid()
/*     */     {
/* 799 */       return this.fighterid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getOp_type()
/*     */     {
/* 806 */       return this.op_type;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public <T extends Marshal> T getContent(T _v_)
/*     */     {
/*     */       try
/*     */       {
/* 815 */         _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.content)));
/* 816 */         return _v_;
/*     */       }
/*     */       catch (MarshalException _e_)
/*     */       {
/* 820 */         throw new xio.MarshalError();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isContentEmpty()
/*     */     {
/* 828 */       return this.content.length == 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public byte[] getContentCopy()
/*     */     {
/* 835 */       return Arrays.copyOf(this.content, this.content.length);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFighterid(int _v_)
/*     */     {
/* 842 */       this.fighterid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOp_type(int _v_)
/*     */     {
/* 849 */       this.op_type = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContent(Marshal _v_)
/*     */     {
/* 856 */       this.content = _v_.marshal(new OctetsStream()).getBytes();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContentCopy(byte[] _v_)
/*     */     {
/* 863 */       this.content = Arrays.copyOf(_v_, _v_.length);
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 869 */       if (!(_o1_ instanceof Data)) return false;
/* 870 */       Data _o_ = (Data)_o1_;
/* 871 */       if (this.fighterid != _o_.fighterid) return false;
/* 872 */       if (this.op_type != _o_.op_type) return false;
/* 873 */       if (!Arrays.equals(this.content, _o_.content)) return false;
/* 874 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 880 */       int _h_ = 0;
/* 881 */       _h_ += this.fighterid;
/* 882 */       _h_ += this.op_type;
/* 883 */       _h_ += Arrays.hashCode(this.content);
/* 884 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 890 */       StringBuilder _sb_ = new StringBuilder();
/* 891 */       _sb_.append("(");
/* 892 */       _sb_.append(this.fighterid);
/* 893 */       _sb_.append(",");
/* 894 */       _sb_.append(this.op_type);
/* 895 */       _sb_.append(",");
/* 896 */       _sb_.append('B').append(this.content.length);
/* 897 */       _sb_.append(")");
/* 898 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FightCmd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */