/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
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
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class CakeData extends XBean implements xbean.CakeData
/*      */ {
/*      */   private int curturn;
/*      */   private int collectnum;
/*      */   private int cookselfcount;
/*      */   private int cookothercount;
/*      */   private long effectfactionid;
/*      */   private int eateselfcaketime;
/*      */   private int eateothercaketime;
/*      */   private long updateeatetime;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.curturn = 0;
/*   33 */     this.collectnum = 0;
/*   34 */     this.cookselfcount = 0;
/*   35 */     this.cookothercount = 0;
/*   36 */     this.effectfactionid = 0L;
/*   37 */     this.eateselfcaketime = 0;
/*   38 */     this.eateothercaketime = 0;
/*   39 */     this.updateeatetime = 0L;
/*      */   }
/*      */   
/*      */   CakeData(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public CakeData()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CakeData(CakeData _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CakeData(xbean.CakeData _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof CakeData)) { assign((CakeData)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CakeData _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.curturn = _o_.curturn;
/*   70 */     this.collectnum = _o_.collectnum;
/*   71 */     this.cookselfcount = _o_.cookselfcount;
/*   72 */     this.cookothercount = _o_.cookothercount;
/*   73 */     this.effectfactionid = _o_.effectfactionid;
/*   74 */     this.eateselfcaketime = _o_.eateselfcaketime;
/*   75 */     this.eateothercaketime = _o_.eateothercaketime;
/*   76 */     this.updateeatetime = _o_.updateeatetime;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   81 */     this.curturn = _o_.curturn;
/*   82 */     this.collectnum = _o_.collectnum;
/*   83 */     this.cookselfcount = _o_.cookselfcount;
/*   84 */     this.cookothercount = _o_.cookothercount;
/*   85 */     this.effectfactionid = _o_.effectfactionid;
/*   86 */     this.eateselfcaketime = _o_.eateselfcaketime;
/*   87 */     this.eateothercaketime = _o_.eateothercaketime;
/*   88 */     this.updateeatetime = _o_.updateeatetime;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   94 */     _xdb_verify_unsafe_();
/*   95 */     _os_.marshal(this.curturn);
/*   96 */     _os_.marshal(this.collectnum);
/*   97 */     _os_.marshal(this.cookselfcount);
/*   98 */     _os_.marshal(this.cookothercount);
/*   99 */     _os_.marshal(this.effectfactionid);
/*  100 */     _os_.marshal(this.eateselfcaketime);
/*  101 */     _os_.marshal(this.eateothercaketime);
/*  102 */     _os_.marshal(this.updateeatetime);
/*  103 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  109 */     _xdb_verify_unsafe_();
/*  110 */     this.curturn = _os_.unmarshal_int();
/*  111 */     this.collectnum = _os_.unmarshal_int();
/*  112 */     this.cookselfcount = _os_.unmarshal_int();
/*  113 */     this.cookothercount = _os_.unmarshal_int();
/*  114 */     this.effectfactionid = _os_.unmarshal_long();
/*  115 */     this.eateselfcaketime = _os_.unmarshal_int();
/*  116 */     this.eateothercaketime = _os_.unmarshal_int();
/*  117 */     this.updateeatetime = _os_.unmarshal_long();
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     int _size_ = 0;
/*  126 */     _size_ += CodedOutputStream.computeInt32Size(1, this.curturn);
/*  127 */     _size_ += CodedOutputStream.computeInt32Size(2, this.collectnum);
/*  128 */     _size_ += CodedOutputStream.computeInt32Size(3, this.cookselfcount);
/*  129 */     _size_ += CodedOutputStream.computeInt32Size(4, this.cookothercount);
/*  130 */     _size_ += CodedOutputStream.computeInt64Size(5, this.effectfactionid);
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(6, this.eateselfcaketime);
/*  132 */     _size_ += CodedOutputStream.computeInt32Size(7, this.eateothercaketime);
/*  133 */     _size_ += CodedOutputStream.computeInt64Size(8, this.updateeatetime);
/*  134 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  143 */       _output_.writeInt32(1, this.curturn);
/*  144 */       _output_.writeInt32(2, this.collectnum);
/*  145 */       _output_.writeInt32(3, this.cookselfcount);
/*  146 */       _output_.writeInt32(4, this.cookothercount);
/*  147 */       _output_.writeInt64(5, this.effectfactionid);
/*  148 */       _output_.writeInt32(6, this.eateselfcaketime);
/*  149 */       _output_.writeInt32(7, this.eateothercaketime);
/*  150 */       _output_.writeInt64(8, this.updateeatetime);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  154 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  156 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  165 */       boolean done = false;
/*  166 */       while (!done)
/*      */       {
/*  168 */         int tag = _input_.readTag();
/*  169 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  173 */           done = true;
/*  174 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  178 */           this.curturn = _input_.readInt32();
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  183 */           this.collectnum = _input_.readInt32();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  188 */           this.cookselfcount = _input_.readInt32();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  193 */           this.cookothercount = _input_.readInt32();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  198 */           this.effectfactionid = _input_.readInt64();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  203 */           this.eateselfcaketime = _input_.readInt32();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  208 */           this.eateothercaketime = _input_.readInt32();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  213 */           this.updateeatetime = _input_.readInt64();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  218 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  220 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  229 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  233 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  235 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CakeData copy()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new CakeData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CakeData toData()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CakeData toBean()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new CakeData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CakeData toDataIf()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CakeData toBeanIf()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurturn()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return this.curturn;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCollectnum()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return this.collectnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCookselfcount()
/*      */   {
/*  298 */     _xdb_verify_unsafe_();
/*  299 */     return this.cookselfcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCookothercount()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return this.cookothercount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEffectfactionid()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return this.effectfactionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getEateselfcaketime()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return this.eateselfcaketime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getEateothercaketime()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*  331 */     return this.eateothercaketime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getUpdateeatetime()
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     return this.updateeatetime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurturn(int _v_)
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     Logs.logIf(new LogKey(this, "curturn")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  351 */         new LogInt(this, CakeData.this.curturn)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  355 */             CakeData.this.curturn = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  359 */     });
/*  360 */     this.curturn = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCollectnum(int _v_)
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     Logs.logIf(new LogKey(this, "collectnum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  372 */         new LogInt(this, CakeData.this.collectnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  376 */             CakeData.this.collectnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  380 */     });
/*  381 */     this.collectnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCookselfcount(int _v_)
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     Logs.logIf(new LogKey(this, "cookselfcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  393 */         new LogInt(this, CakeData.this.cookselfcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  397 */             CakeData.this.cookselfcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  401 */     });
/*  402 */     this.cookselfcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCookothercount(int _v_)
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     Logs.logIf(new LogKey(this, "cookothercount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  414 */         new LogInt(this, CakeData.this.cookothercount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  418 */             CakeData.this.cookothercount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  422 */     });
/*  423 */     this.cookothercount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEffectfactionid(long _v_)
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     Logs.logIf(new LogKey(this, "effectfactionid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  435 */         new LogLong(this, CakeData.this.effectfactionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  439 */             CakeData.this.effectfactionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  443 */     });
/*  444 */     this.effectfactionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEateselfcaketime(int _v_)
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     Logs.logIf(new LogKey(this, "eateselfcaketime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  456 */         new LogInt(this, CakeData.this.eateselfcaketime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  460 */             CakeData.this.eateselfcaketime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  464 */     });
/*  465 */     this.eateselfcaketime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEateothercaketime(int _v_)
/*      */   {
/*  472 */     _xdb_verify_unsafe_();
/*  473 */     Logs.logIf(new LogKey(this, "eateothercaketime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  477 */         new LogInt(this, CakeData.this.eateothercaketime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  481 */             CakeData.this.eateothercaketime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  485 */     });
/*  486 */     this.eateothercaketime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUpdateeatetime(long _v_)
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     Logs.logIf(new LogKey(this, "updateeatetime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  498 */         new LogLong(this, CakeData.this.updateeatetime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  502 */             CakeData.this.updateeatetime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  506 */     });
/*  507 */     this.updateeatetime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     CakeData _o_ = null;
/*  515 */     if ((_o1_ instanceof CakeData)) { _o_ = (CakeData)_o1_;
/*  516 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  517 */       return false;
/*  518 */     if (this.curturn != _o_.curturn) return false;
/*  519 */     if (this.collectnum != _o_.collectnum) return false;
/*  520 */     if (this.cookselfcount != _o_.cookselfcount) return false;
/*  521 */     if (this.cookothercount != _o_.cookothercount) return false;
/*  522 */     if (this.effectfactionid != _o_.effectfactionid) return false;
/*  523 */     if (this.eateselfcaketime != _o_.eateselfcaketime) return false;
/*  524 */     if (this.eateothercaketime != _o_.eateothercaketime) return false;
/*  525 */     if (this.updateeatetime != _o_.updateeatetime) return false;
/*  526 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  532 */     _xdb_verify_unsafe_();
/*  533 */     int _h_ = 0;
/*  534 */     _h_ += this.curturn;
/*  535 */     _h_ += this.collectnum;
/*  536 */     _h_ += this.cookselfcount;
/*  537 */     _h_ += this.cookothercount;
/*  538 */     _h_ = (int)(_h_ + this.effectfactionid);
/*  539 */     _h_ += this.eateselfcaketime;
/*  540 */     _h_ += this.eateothercaketime;
/*  541 */     _h_ = (int)(_h_ + this.updateeatetime);
/*  542 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  548 */     _xdb_verify_unsafe_();
/*  549 */     StringBuilder _sb_ = new StringBuilder();
/*  550 */     _sb_.append("(");
/*  551 */     _sb_.append(this.curturn);
/*  552 */     _sb_.append(",");
/*  553 */     _sb_.append(this.collectnum);
/*  554 */     _sb_.append(",");
/*  555 */     _sb_.append(this.cookselfcount);
/*  556 */     _sb_.append(",");
/*  557 */     _sb_.append(this.cookothercount);
/*  558 */     _sb_.append(",");
/*  559 */     _sb_.append(this.effectfactionid);
/*  560 */     _sb_.append(",");
/*  561 */     _sb_.append(this.eateselfcaketime);
/*  562 */     _sb_.append(",");
/*  563 */     _sb_.append(this.eateothercaketime);
/*  564 */     _sb_.append(",");
/*  565 */     _sb_.append(this.updateeatetime);
/*  566 */     _sb_.append(")");
/*  567 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  573 */     ListenableBean lb = new ListenableBean();
/*  574 */     lb.add(new ListenableChanged().setVarName("curturn"));
/*  575 */     lb.add(new ListenableChanged().setVarName("collectnum"));
/*  576 */     lb.add(new ListenableChanged().setVarName("cookselfcount"));
/*  577 */     lb.add(new ListenableChanged().setVarName("cookothercount"));
/*  578 */     lb.add(new ListenableChanged().setVarName("effectfactionid"));
/*  579 */     lb.add(new ListenableChanged().setVarName("eateselfcaketime"));
/*  580 */     lb.add(new ListenableChanged().setVarName("eateothercaketime"));
/*  581 */     lb.add(new ListenableChanged().setVarName("updateeatetime"));
/*  582 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CakeData {
/*      */     private Const() {}
/*      */     
/*      */     CakeData nThis() {
/*  589 */       return CakeData.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  595 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeData copy()
/*      */     {
/*  601 */       return CakeData.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeData toData()
/*      */     {
/*  607 */       return CakeData.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CakeData toBean()
/*      */     {
/*  612 */       return CakeData.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeData toDataIf()
/*      */     {
/*  618 */       return CakeData.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CakeData toBeanIf()
/*      */     {
/*  623 */       return CakeData.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurturn()
/*      */     {
/*  630 */       CakeData.this._xdb_verify_unsafe_();
/*  631 */       return CakeData.this.curturn;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCollectnum()
/*      */     {
/*  638 */       CakeData.this._xdb_verify_unsafe_();
/*  639 */       return CakeData.this.collectnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCookselfcount()
/*      */     {
/*  646 */       CakeData.this._xdb_verify_unsafe_();
/*  647 */       return CakeData.this.cookselfcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCookothercount()
/*      */     {
/*  654 */       CakeData.this._xdb_verify_unsafe_();
/*  655 */       return CakeData.this.cookothercount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEffectfactionid()
/*      */     {
/*  662 */       CakeData.this._xdb_verify_unsafe_();
/*  663 */       return CakeData.this.effectfactionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEateselfcaketime()
/*      */     {
/*  670 */       CakeData.this._xdb_verify_unsafe_();
/*  671 */       return CakeData.this.eateselfcaketime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEateothercaketime()
/*      */     {
/*  678 */       CakeData.this._xdb_verify_unsafe_();
/*  679 */       return CakeData.this.eateothercaketime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getUpdateeatetime()
/*      */     {
/*  686 */       CakeData.this._xdb_verify_unsafe_();
/*  687 */       return CakeData.this.updateeatetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurturn(int _v_)
/*      */     {
/*  694 */       CakeData.this._xdb_verify_unsafe_();
/*  695 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCollectnum(int _v_)
/*      */     {
/*  702 */       CakeData.this._xdb_verify_unsafe_();
/*  703 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCookselfcount(int _v_)
/*      */     {
/*  710 */       CakeData.this._xdb_verify_unsafe_();
/*  711 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCookothercount(int _v_)
/*      */     {
/*  718 */       CakeData.this._xdb_verify_unsafe_();
/*  719 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEffectfactionid(long _v_)
/*      */     {
/*  726 */       CakeData.this._xdb_verify_unsafe_();
/*  727 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEateselfcaketime(int _v_)
/*      */     {
/*  734 */       CakeData.this._xdb_verify_unsafe_();
/*  735 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEateothercaketime(int _v_)
/*      */     {
/*  742 */       CakeData.this._xdb_verify_unsafe_();
/*  743 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdateeatetime(long _v_)
/*      */     {
/*  750 */       CakeData.this._xdb_verify_unsafe_();
/*  751 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  757 */       CakeData.this._xdb_verify_unsafe_();
/*  758 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  764 */       CakeData.this._xdb_verify_unsafe_();
/*  765 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  771 */       return CakeData.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  777 */       return CakeData.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  783 */       CakeData.this._xdb_verify_unsafe_();
/*  784 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  790 */       return CakeData.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  796 */       return CakeData.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  802 */       CakeData.this._xdb_verify_unsafe_();
/*  803 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  809 */       return CakeData.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  815 */       return CakeData.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  821 */       return CakeData.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  827 */       return CakeData.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  833 */       return CakeData.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  839 */       return CakeData.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  845 */       return CakeData.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CakeData
/*      */   {
/*      */     private int curturn;
/*      */     
/*      */     private int collectnum;
/*      */     
/*      */     private int cookselfcount;
/*      */     
/*      */     private int cookothercount;
/*      */     
/*      */     private long effectfactionid;
/*      */     
/*      */     private int eateselfcaketime;
/*      */     
/*      */     private int eateothercaketime;
/*      */     
/*      */     private long updateeatetime;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  871 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.CakeData _o1_)
/*      */     {
/*  880 */       if ((_o1_ instanceof CakeData)) { assign((CakeData)_o1_);
/*  881 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  882 */       } else if ((_o1_ instanceof CakeData.Const)) assign(((CakeData.Const)_o1_).nThis()); else {
/*  883 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CakeData _o_) {
/*  888 */       this.curturn = _o_.curturn;
/*  889 */       this.collectnum = _o_.collectnum;
/*  890 */       this.cookselfcount = _o_.cookselfcount;
/*  891 */       this.cookothercount = _o_.cookothercount;
/*  892 */       this.effectfactionid = _o_.effectfactionid;
/*  893 */       this.eateselfcaketime = _o_.eateselfcaketime;
/*  894 */       this.eateothercaketime = _o_.eateothercaketime;
/*  895 */       this.updateeatetime = _o_.updateeatetime;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  900 */       this.curturn = _o_.curturn;
/*  901 */       this.collectnum = _o_.collectnum;
/*  902 */       this.cookselfcount = _o_.cookselfcount;
/*  903 */       this.cookothercount = _o_.cookothercount;
/*  904 */       this.effectfactionid = _o_.effectfactionid;
/*  905 */       this.eateselfcaketime = _o_.eateselfcaketime;
/*  906 */       this.eateothercaketime = _o_.eateothercaketime;
/*  907 */       this.updateeatetime = _o_.updateeatetime;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  913 */       _os_.marshal(this.curturn);
/*  914 */       _os_.marshal(this.collectnum);
/*  915 */       _os_.marshal(this.cookselfcount);
/*  916 */       _os_.marshal(this.cookothercount);
/*  917 */       _os_.marshal(this.effectfactionid);
/*  918 */       _os_.marshal(this.eateselfcaketime);
/*  919 */       _os_.marshal(this.eateothercaketime);
/*  920 */       _os_.marshal(this.updateeatetime);
/*  921 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  927 */       this.curturn = _os_.unmarshal_int();
/*  928 */       this.collectnum = _os_.unmarshal_int();
/*  929 */       this.cookselfcount = _os_.unmarshal_int();
/*  930 */       this.cookothercount = _os_.unmarshal_int();
/*  931 */       this.effectfactionid = _os_.unmarshal_long();
/*  932 */       this.eateselfcaketime = _os_.unmarshal_int();
/*  933 */       this.eateothercaketime = _os_.unmarshal_int();
/*  934 */       this.updateeatetime = _os_.unmarshal_long();
/*  935 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  941 */       int _size_ = 0;
/*  942 */       _size_ += CodedOutputStream.computeInt32Size(1, this.curturn);
/*  943 */       _size_ += CodedOutputStream.computeInt32Size(2, this.collectnum);
/*  944 */       _size_ += CodedOutputStream.computeInt32Size(3, this.cookselfcount);
/*  945 */       _size_ += CodedOutputStream.computeInt32Size(4, this.cookothercount);
/*  946 */       _size_ += CodedOutputStream.computeInt64Size(5, this.effectfactionid);
/*  947 */       _size_ += CodedOutputStream.computeInt32Size(6, this.eateselfcaketime);
/*  948 */       _size_ += CodedOutputStream.computeInt32Size(7, this.eateothercaketime);
/*  949 */       _size_ += CodedOutputStream.computeInt64Size(8, this.updateeatetime);
/*  950 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  958 */         _output_.writeInt32(1, this.curturn);
/*  959 */         _output_.writeInt32(2, this.collectnum);
/*  960 */         _output_.writeInt32(3, this.cookselfcount);
/*  961 */         _output_.writeInt32(4, this.cookothercount);
/*  962 */         _output_.writeInt64(5, this.effectfactionid);
/*  963 */         _output_.writeInt32(6, this.eateselfcaketime);
/*  964 */         _output_.writeInt32(7, this.eateothercaketime);
/*  965 */         _output_.writeInt64(8, this.updateeatetime);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  969 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  971 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  979 */         boolean done = false;
/*  980 */         while (!done)
/*      */         {
/*  982 */           int tag = _input_.readTag();
/*  983 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  987 */             done = true;
/*  988 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  992 */             this.curturn = _input_.readInt32();
/*  993 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  997 */             this.collectnum = _input_.readInt32();
/*  998 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1002 */             this.cookselfcount = _input_.readInt32();
/* 1003 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1007 */             this.cookothercount = _input_.readInt32();
/* 1008 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1012 */             this.effectfactionid = _input_.readInt64();
/* 1013 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1017 */             this.eateselfcaketime = _input_.readInt32();
/* 1018 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1022 */             this.eateothercaketime = _input_.readInt32();
/* 1023 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1027 */             this.updateeatetime = _input_.readInt64();
/* 1028 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1032 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1034 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1043 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1047 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1049 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeData copy()
/*      */     {
/* 1055 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeData toData()
/*      */     {
/* 1061 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CakeData toBean()
/*      */     {
/* 1066 */       return new CakeData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CakeData toDataIf()
/*      */     {
/* 1072 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CakeData toBeanIf()
/*      */     {
/* 1077 */       return new CakeData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1083 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1087 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1091 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1095 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1099 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1103 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1107 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurturn()
/*      */     {
/* 1114 */       return this.curturn;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCollectnum()
/*      */     {
/* 1121 */       return this.collectnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCookselfcount()
/*      */     {
/* 1128 */       return this.cookselfcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCookothercount()
/*      */     {
/* 1135 */       return this.cookothercount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEffectfactionid()
/*      */     {
/* 1142 */       return this.effectfactionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEateselfcaketime()
/*      */     {
/* 1149 */       return this.eateselfcaketime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getEateothercaketime()
/*      */     {
/* 1156 */       return this.eateothercaketime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getUpdateeatetime()
/*      */     {
/* 1163 */       return this.updateeatetime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurturn(int _v_)
/*      */     {
/* 1170 */       this.curturn = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCollectnum(int _v_)
/*      */     {
/* 1177 */       this.collectnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCookselfcount(int _v_)
/*      */     {
/* 1184 */       this.cookselfcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCookothercount(int _v_)
/*      */     {
/* 1191 */       this.cookothercount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEffectfactionid(long _v_)
/*      */     {
/* 1198 */       this.effectfactionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEateselfcaketime(int _v_)
/*      */     {
/* 1205 */       this.eateselfcaketime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEateothercaketime(int _v_)
/*      */     {
/* 1212 */       this.eateothercaketime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUpdateeatetime(long _v_)
/*      */     {
/* 1219 */       this.updateeatetime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1225 */       if (!(_o1_ instanceof Data)) return false;
/* 1226 */       Data _o_ = (Data)_o1_;
/* 1227 */       if (this.curturn != _o_.curturn) return false;
/* 1228 */       if (this.collectnum != _o_.collectnum) return false;
/* 1229 */       if (this.cookselfcount != _o_.cookselfcount) return false;
/* 1230 */       if (this.cookothercount != _o_.cookothercount) return false;
/* 1231 */       if (this.effectfactionid != _o_.effectfactionid) return false;
/* 1232 */       if (this.eateselfcaketime != _o_.eateselfcaketime) return false;
/* 1233 */       if (this.eateothercaketime != _o_.eateothercaketime) return false;
/* 1234 */       if (this.updateeatetime != _o_.updateeatetime) return false;
/* 1235 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1241 */       int _h_ = 0;
/* 1242 */       _h_ += this.curturn;
/* 1243 */       _h_ += this.collectnum;
/* 1244 */       _h_ += this.cookselfcount;
/* 1245 */       _h_ += this.cookothercount;
/* 1246 */       _h_ = (int)(_h_ + this.effectfactionid);
/* 1247 */       _h_ += this.eateselfcaketime;
/* 1248 */       _h_ += this.eateothercaketime;
/* 1249 */       _h_ = (int)(_h_ + this.updateeatetime);
/* 1250 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1256 */       StringBuilder _sb_ = new StringBuilder();
/* 1257 */       _sb_.append("(");
/* 1258 */       _sb_.append(this.curturn);
/* 1259 */       _sb_.append(",");
/* 1260 */       _sb_.append(this.collectnum);
/* 1261 */       _sb_.append(",");
/* 1262 */       _sb_.append(this.cookselfcount);
/* 1263 */       _sb_.append(",");
/* 1264 */       _sb_.append(this.cookothercount);
/* 1265 */       _sb_.append(",");
/* 1266 */       _sb_.append(this.effectfactionid);
/* 1267 */       _sb_.append(",");
/* 1268 */       _sb_.append(this.eateselfcaketime);
/* 1269 */       _sb_.append(",");
/* 1270 */       _sb_.append(this.eateothercaketime);
/* 1271 */       _sb_.append(",");
/* 1272 */       _sb_.append(this.updateeatetime);
/* 1273 */       _sb_.append(")");
/* 1274 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CakeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */