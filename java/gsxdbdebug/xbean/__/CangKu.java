/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class CangKu extends XBean implements xbean.CangKu
/*      */ {
/*      */   private int level;
/*      */   private long levelupendtime;
/*      */   private int fulinumtotal;
/*      */   private int avaliablefulinum;
/*      */   private long lastupdatefulitime;
/*      */   private int lihenum;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.level = 0;
/*   29 */     this.levelupendtime = 0L;
/*   30 */     this.fulinumtotal = 0;
/*   31 */     this.avaliablefulinum = 0;
/*   32 */     this.lastupdatefulitime = 0L;
/*   33 */     this.lihenum = 0;
/*      */   }
/*      */   
/*      */   CangKu(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public CangKu()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CangKu(CangKu _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CangKu(xbean.CangKu _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof CangKu)) { assign((CangKu)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CangKu _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.level = _o_.level;
/*   64 */     this.levelupendtime = _o_.levelupendtime;
/*   65 */     this.fulinumtotal = _o_.fulinumtotal;
/*   66 */     this.avaliablefulinum = _o_.avaliablefulinum;
/*   67 */     this.lastupdatefulitime = _o_.lastupdatefulitime;
/*   68 */     this.lihenum = _o_.lihenum;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   73 */     this.level = _o_.level;
/*   74 */     this.levelupendtime = _o_.levelupendtime;
/*   75 */     this.fulinumtotal = _o_.fulinumtotal;
/*   76 */     this.avaliablefulinum = _o_.avaliablefulinum;
/*   77 */     this.lastupdatefulitime = _o_.lastupdatefulitime;
/*   78 */     this.lihenum = _o_.lihenum;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.level);
/*   86 */     _os_.marshal(this.levelupendtime);
/*   87 */     _os_.marshal(this.fulinumtotal);
/*   88 */     _os_.marshal(this.avaliablefulinum);
/*   89 */     _os_.marshal(this.lastupdatefulitime);
/*   90 */     _os_.marshal(this.lihenum);
/*   91 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   97 */     _xdb_verify_unsafe_();
/*   98 */     this.level = _os_.unmarshal_int();
/*   99 */     this.levelupendtime = _os_.unmarshal_long();
/*  100 */     this.fulinumtotal = _os_.unmarshal_int();
/*  101 */     this.avaliablefulinum = _os_.unmarshal_int();
/*  102 */     this.lastupdatefulitime = _os_.unmarshal_long();
/*  103 */     this.lihenum = _os_.unmarshal_int();
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     int _size_ = 0;
/*  112 */     _size_ += CodedOutputStream.computeInt32Size(1, this.level);
/*  113 */     _size_ += CodedOutputStream.computeInt64Size(2, this.levelupendtime);
/*  114 */     _size_ += CodedOutputStream.computeInt32Size(3, this.fulinumtotal);
/*  115 */     _size_ += CodedOutputStream.computeInt32Size(4, this.avaliablefulinum);
/*  116 */     _size_ += CodedOutputStream.computeInt64Size(5, this.lastupdatefulitime);
/*  117 */     _size_ += CodedOutputStream.computeInt32Size(6, this.lihenum);
/*  118 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  127 */       _output_.writeInt32(1, this.level);
/*  128 */       _output_.writeInt64(2, this.levelupendtime);
/*  129 */       _output_.writeInt32(3, this.fulinumtotal);
/*  130 */       _output_.writeInt32(4, this.avaliablefulinum);
/*  131 */       _output_.writeInt64(5, this.lastupdatefulitime);
/*  132 */       _output_.writeInt32(6, this.lihenum);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  138 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  147 */       boolean done = false;
/*  148 */       while (!done)
/*      */       {
/*  150 */         int tag = _input_.readTag();
/*  151 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  155 */           done = true;
/*  156 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  160 */           this.level = _input_.readInt32();
/*  161 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  165 */           this.levelupendtime = _input_.readInt64();
/*  166 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  170 */           this.fulinumtotal = _input_.readInt32();
/*  171 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  175 */           this.avaliablefulinum = _input_.readInt32();
/*  176 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  180 */           this.lastupdatefulitime = _input_.readInt64();
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  185 */           this.lihenum = _input_.readInt32();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  190 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  192 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  201 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  205 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  207 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CangKu copy()
/*      */   {
/*  213 */     _xdb_verify_unsafe_();
/*  214 */     return new CangKu(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CangKu toData()
/*      */   {
/*  220 */     _xdb_verify_unsafe_();
/*  221 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CangKu toBean()
/*      */   {
/*  226 */     _xdb_verify_unsafe_();
/*  227 */     return new CangKu(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CangKu toDataIf()
/*      */   {
/*  233 */     _xdb_verify_unsafe_();
/*  234 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CangKu toBeanIf()
/*      */   {
/*  239 */     _xdb_verify_unsafe_();
/*  240 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  246 */     _xdb_verify_unsafe_();
/*  247 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return this.level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLevelupendtime()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return this.levelupendtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFulinumtotal()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this.fulinumtotal;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAvaliablefulinum()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return this.avaliablefulinum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastupdatefulitime()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this.lastupdatefulitime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLihenum()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.lihenum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevel(int _v_)
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     Logs.logIf(new LogKey(this, "level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  307 */         new LogInt(this, CangKu.this.level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  311 */             CangKu.this.level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  315 */     });
/*  316 */     this.level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevelupendtime(long _v_)
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     Logs.logIf(new LogKey(this, "levelupendtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  328 */         new xdb.logs.LogLong(this, CangKu.this.levelupendtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  332 */             CangKu.this.levelupendtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  336 */     });
/*  337 */     this.levelupendtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFulinumtotal(int _v_)
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     Logs.logIf(new LogKey(this, "fulinumtotal")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  349 */         new LogInt(this, CangKu.this.fulinumtotal)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  353 */             CangKu.this.fulinumtotal = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  357 */     });
/*  358 */     this.fulinumtotal = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAvaliablefulinum(int _v_)
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     Logs.logIf(new LogKey(this, "avaliablefulinum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  370 */         new LogInt(this, CangKu.this.avaliablefulinum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  374 */             CangKu.this.avaliablefulinum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  378 */     });
/*  379 */     this.avaliablefulinum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastupdatefulitime(long _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     Logs.logIf(new LogKey(this, "lastupdatefulitime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  391 */         new xdb.logs.LogLong(this, CangKu.this.lastupdatefulitime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  395 */             CangKu.this.lastupdatefulitime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  399 */     });
/*  400 */     this.lastupdatefulitime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLihenum(int _v_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     Logs.logIf(new LogKey(this, "lihenum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  412 */         new LogInt(this, CangKu.this.lihenum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  416 */             CangKu.this.lihenum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  420 */     });
/*  421 */     this.lihenum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     CangKu _o_ = null;
/*  429 */     if ((_o1_ instanceof CangKu)) { _o_ = (CangKu)_o1_;
/*  430 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  431 */       return false;
/*  432 */     if (this.level != _o_.level) return false;
/*  433 */     if (this.levelupendtime != _o_.levelupendtime) return false;
/*  434 */     if (this.fulinumtotal != _o_.fulinumtotal) return false;
/*  435 */     if (this.avaliablefulinum != _o_.avaliablefulinum) return false;
/*  436 */     if (this.lastupdatefulitime != _o_.lastupdatefulitime) return false;
/*  437 */     if (this.lihenum != _o_.lihenum) return false;
/*  438 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     int _h_ = 0;
/*  446 */     _h_ += this.level;
/*  447 */     _h_ = (int)(_h_ + this.levelupendtime);
/*  448 */     _h_ += this.fulinumtotal;
/*  449 */     _h_ += this.avaliablefulinum;
/*  450 */     _h_ = (int)(_h_ + this.lastupdatefulitime);
/*  451 */     _h_ += this.lihenum;
/*  452 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*  459 */     StringBuilder _sb_ = new StringBuilder();
/*  460 */     _sb_.append("(");
/*  461 */     _sb_.append(this.level);
/*  462 */     _sb_.append(",");
/*  463 */     _sb_.append(this.levelupendtime);
/*  464 */     _sb_.append(",");
/*  465 */     _sb_.append(this.fulinumtotal);
/*  466 */     _sb_.append(",");
/*  467 */     _sb_.append(this.avaliablefulinum);
/*  468 */     _sb_.append(",");
/*  469 */     _sb_.append(this.lastupdatefulitime);
/*  470 */     _sb_.append(",");
/*  471 */     _sb_.append(this.lihenum);
/*  472 */     _sb_.append(")");
/*  473 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  479 */     ListenableBean lb = new ListenableBean();
/*  480 */     lb.add(new ListenableChanged().setVarName("level"));
/*  481 */     lb.add(new ListenableChanged().setVarName("levelupendtime"));
/*  482 */     lb.add(new ListenableChanged().setVarName("fulinumtotal"));
/*  483 */     lb.add(new ListenableChanged().setVarName("avaliablefulinum"));
/*  484 */     lb.add(new ListenableChanged().setVarName("lastupdatefulitime"));
/*  485 */     lb.add(new ListenableChanged().setVarName("lihenum"));
/*  486 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CangKu {
/*      */     private Const() {}
/*      */     
/*      */     CangKu nThis() {
/*  493 */       return CangKu.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  499 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CangKu copy()
/*      */     {
/*  505 */       return CangKu.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CangKu toData()
/*      */     {
/*  511 */       return CangKu.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CangKu toBean()
/*      */     {
/*  516 */       return CangKu.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CangKu toDataIf()
/*      */     {
/*  522 */       return CangKu.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CangKu toBeanIf()
/*      */     {
/*  527 */       return CangKu.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/*  534 */       CangKu.this._xdb_verify_unsafe_();
/*  535 */       return CangKu.this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLevelupendtime()
/*      */     {
/*  542 */       CangKu.this._xdb_verify_unsafe_();
/*  543 */       return CangKu.this.levelupendtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFulinumtotal()
/*      */     {
/*  550 */       CangKu.this._xdb_verify_unsafe_();
/*  551 */       return CangKu.this.fulinumtotal;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAvaliablefulinum()
/*      */     {
/*  558 */       CangKu.this._xdb_verify_unsafe_();
/*  559 */       return CangKu.this.avaliablefulinum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastupdatefulitime()
/*      */     {
/*  566 */       CangKu.this._xdb_verify_unsafe_();
/*  567 */       return CangKu.this.lastupdatefulitime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLihenum()
/*      */     {
/*  574 */       CangKu.this._xdb_verify_unsafe_();
/*  575 */       return CangKu.this.lihenum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/*  582 */       CangKu.this._xdb_verify_unsafe_();
/*  583 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevelupendtime(long _v_)
/*      */     {
/*  590 */       CangKu.this._xdb_verify_unsafe_();
/*  591 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFulinumtotal(int _v_)
/*      */     {
/*  598 */       CangKu.this._xdb_verify_unsafe_();
/*  599 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAvaliablefulinum(int _v_)
/*      */     {
/*  606 */       CangKu.this._xdb_verify_unsafe_();
/*  607 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastupdatefulitime(long _v_)
/*      */     {
/*  614 */       CangKu.this._xdb_verify_unsafe_();
/*  615 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLihenum(int _v_)
/*      */     {
/*  622 */       CangKu.this._xdb_verify_unsafe_();
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  629 */       CangKu.this._xdb_verify_unsafe_();
/*  630 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  636 */       CangKu.this._xdb_verify_unsafe_();
/*  637 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  643 */       return CangKu.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  649 */       return CangKu.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  655 */       CangKu.this._xdb_verify_unsafe_();
/*  656 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  662 */       return CangKu.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  668 */       return CangKu.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  674 */       CangKu.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  681 */       return CangKu.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  687 */       return CangKu.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  693 */       return CangKu.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  699 */       return CangKu.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  705 */       return CangKu.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  711 */       return CangKu.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  717 */       return CangKu.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CangKu
/*      */   {
/*      */     private int level;
/*      */     
/*      */     private long levelupendtime;
/*      */     
/*      */     private int fulinumtotal;
/*      */     
/*      */     private int avaliablefulinum;
/*      */     
/*      */     private long lastupdatefulitime;
/*      */     
/*      */     private int lihenum;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.CangKu _o1_)
/*      */     {
/*  748 */       if ((_o1_ instanceof CangKu)) { assign((CangKu)_o1_);
/*  749 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  750 */       } else if ((_o1_ instanceof CangKu.Const)) assign(((CangKu.Const)_o1_).nThis()); else {
/*  751 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CangKu _o_) {
/*  756 */       this.level = _o_.level;
/*  757 */       this.levelupendtime = _o_.levelupendtime;
/*  758 */       this.fulinumtotal = _o_.fulinumtotal;
/*  759 */       this.avaliablefulinum = _o_.avaliablefulinum;
/*  760 */       this.lastupdatefulitime = _o_.lastupdatefulitime;
/*  761 */       this.lihenum = _o_.lihenum;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  766 */       this.level = _o_.level;
/*  767 */       this.levelupendtime = _o_.levelupendtime;
/*  768 */       this.fulinumtotal = _o_.fulinumtotal;
/*  769 */       this.avaliablefulinum = _o_.avaliablefulinum;
/*  770 */       this.lastupdatefulitime = _o_.lastupdatefulitime;
/*  771 */       this.lihenum = _o_.lihenum;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  777 */       _os_.marshal(this.level);
/*  778 */       _os_.marshal(this.levelupendtime);
/*  779 */       _os_.marshal(this.fulinumtotal);
/*  780 */       _os_.marshal(this.avaliablefulinum);
/*  781 */       _os_.marshal(this.lastupdatefulitime);
/*  782 */       _os_.marshal(this.lihenum);
/*  783 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  789 */       this.level = _os_.unmarshal_int();
/*  790 */       this.levelupendtime = _os_.unmarshal_long();
/*  791 */       this.fulinumtotal = _os_.unmarshal_int();
/*  792 */       this.avaliablefulinum = _os_.unmarshal_int();
/*  793 */       this.lastupdatefulitime = _os_.unmarshal_long();
/*  794 */       this.lihenum = _os_.unmarshal_int();
/*  795 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  801 */       int _size_ = 0;
/*  802 */       _size_ += CodedOutputStream.computeInt32Size(1, this.level);
/*  803 */       _size_ += CodedOutputStream.computeInt64Size(2, this.levelupendtime);
/*  804 */       _size_ += CodedOutputStream.computeInt32Size(3, this.fulinumtotal);
/*  805 */       _size_ += CodedOutputStream.computeInt32Size(4, this.avaliablefulinum);
/*  806 */       _size_ += CodedOutputStream.computeInt64Size(5, this.lastupdatefulitime);
/*  807 */       _size_ += CodedOutputStream.computeInt32Size(6, this.lihenum);
/*  808 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  816 */         _output_.writeInt32(1, this.level);
/*  817 */         _output_.writeInt64(2, this.levelupendtime);
/*  818 */         _output_.writeInt32(3, this.fulinumtotal);
/*  819 */         _output_.writeInt32(4, this.avaliablefulinum);
/*  820 */         _output_.writeInt64(5, this.lastupdatefulitime);
/*  821 */         _output_.writeInt32(6, this.lihenum);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  825 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  827 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  835 */         boolean done = false;
/*  836 */         while (!done)
/*      */         {
/*  838 */           int tag = _input_.readTag();
/*  839 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  843 */             done = true;
/*  844 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  848 */             this.level = _input_.readInt32();
/*  849 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  853 */             this.levelupendtime = _input_.readInt64();
/*  854 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  858 */             this.fulinumtotal = _input_.readInt32();
/*  859 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  863 */             this.avaliablefulinum = _input_.readInt32();
/*  864 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  868 */             this.lastupdatefulitime = _input_.readInt64();
/*  869 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  873 */             this.lihenum = _input_.readInt32();
/*  874 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  878 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  880 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  889 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  893 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  895 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CangKu copy()
/*      */     {
/*  901 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CangKu toData()
/*      */     {
/*  907 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CangKu toBean()
/*      */     {
/*  912 */       return new CangKu(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CangKu toDataIf()
/*      */     {
/*  918 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CangKu toBeanIf()
/*      */     {
/*  923 */       return new CangKu(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  929 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  949 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  953 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/*  960 */       return this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLevelupendtime()
/*      */     {
/*  967 */       return this.levelupendtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFulinumtotal()
/*      */     {
/*  974 */       return this.fulinumtotal;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAvaliablefulinum()
/*      */     {
/*  981 */       return this.avaliablefulinum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastupdatefulitime()
/*      */     {
/*  988 */       return this.lastupdatefulitime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLihenum()
/*      */     {
/*  995 */       return this.lihenum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 1002 */       this.level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevelupendtime(long _v_)
/*      */     {
/* 1009 */       this.levelupendtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFulinumtotal(int _v_)
/*      */     {
/* 1016 */       this.fulinumtotal = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAvaliablefulinum(int _v_)
/*      */     {
/* 1023 */       this.avaliablefulinum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastupdatefulitime(long _v_)
/*      */     {
/* 1030 */       this.lastupdatefulitime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLihenum(int _v_)
/*      */     {
/* 1037 */       this.lihenum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1043 */       if (!(_o1_ instanceof Data)) return false;
/* 1044 */       Data _o_ = (Data)_o1_;
/* 1045 */       if (this.level != _o_.level) return false;
/* 1046 */       if (this.levelupendtime != _o_.levelupendtime) return false;
/* 1047 */       if (this.fulinumtotal != _o_.fulinumtotal) return false;
/* 1048 */       if (this.avaliablefulinum != _o_.avaliablefulinum) return false;
/* 1049 */       if (this.lastupdatefulitime != _o_.lastupdatefulitime) return false;
/* 1050 */       if (this.lihenum != _o_.lihenum) return false;
/* 1051 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1057 */       int _h_ = 0;
/* 1058 */       _h_ += this.level;
/* 1059 */       _h_ = (int)(_h_ + this.levelupendtime);
/* 1060 */       _h_ += this.fulinumtotal;
/* 1061 */       _h_ += this.avaliablefulinum;
/* 1062 */       _h_ = (int)(_h_ + this.lastupdatefulitime);
/* 1063 */       _h_ += this.lihenum;
/* 1064 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1070 */       StringBuilder _sb_ = new StringBuilder();
/* 1071 */       _sb_.append("(");
/* 1072 */       _sb_.append(this.level);
/* 1073 */       _sb_.append(",");
/* 1074 */       _sb_.append(this.levelupendtime);
/* 1075 */       _sb_.append(",");
/* 1076 */       _sb_.append(this.fulinumtotal);
/* 1077 */       _sb_.append(",");
/* 1078 */       _sb_.append(this.avaliablefulinum);
/* 1079 */       _sb_.append(",");
/* 1080 */       _sb_.append(this.lastupdatefulitime);
/* 1081 */       _sb_.append(",");
/* 1082 */       _sb_.append(this.lihenum);
/* 1083 */       _sb_.append(")");
/* 1084 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CangKu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */