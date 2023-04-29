/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class SwornKickOut extends XBean implements xbean.SwornKickOut
/*      */ {
/*      */   private long roleid;
/*      */   private long kickoutid;
/*      */   private long verifytime;
/*      */   private ArrayList<Long> verifyids;
/*      */   private ArrayList<Long> agreevoteids;
/*      */   private ArrayList<Long> notagreevoteids;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.roleid = 0L;
/*   29 */     this.kickoutid = 0L;
/*   30 */     this.verifytime = 0L;
/*   31 */     this.verifyids.clear();
/*   32 */     this.agreevoteids.clear();
/*   33 */     this.notagreevoteids.clear();
/*      */   }
/*      */   
/*      */   SwornKickOut(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.verifytime = 0L;
/*   40 */     this.verifyids = new ArrayList();
/*   41 */     this.agreevoteids = new ArrayList();
/*   42 */     this.notagreevoteids = new ArrayList();
/*      */   }
/*      */   
/*      */   public SwornKickOut()
/*      */   {
/*   47 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public SwornKickOut(SwornKickOut _o_)
/*      */   {
/*   52 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   SwornKickOut(xbean.SwornKickOut _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   57 */     super(_xp_, _vn_);
/*   58 */     if ((_o1_ instanceof SwornKickOut)) { assign((SwornKickOut)_o1_);
/*   59 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   60 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   61 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(SwornKickOut _o_) {
/*   66 */     _o_._xdb_verify_unsafe_();
/*   67 */     this.roleid = _o_.roleid;
/*   68 */     this.kickoutid = _o_.kickoutid;
/*   69 */     this.verifytime = _o_.verifytime;
/*   70 */     this.verifyids = new ArrayList();
/*   71 */     this.verifyids.addAll(_o_.verifyids);
/*   72 */     this.agreevoteids = new ArrayList();
/*   73 */     this.agreevoteids.addAll(_o_.agreevoteids);
/*   74 */     this.notagreevoteids = new ArrayList();
/*   75 */     this.notagreevoteids.addAll(_o_.notagreevoteids);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   80 */     this.roleid = _o_.roleid;
/*   81 */     this.kickoutid = _o_.kickoutid;
/*   82 */     this.verifytime = _o_.verifytime;
/*   83 */     this.verifyids = new ArrayList();
/*   84 */     this.verifyids.addAll(_o_.verifyids);
/*   85 */     this.agreevoteids = new ArrayList();
/*   86 */     this.agreevoteids.addAll(_o_.agreevoteids);
/*   87 */     this.notagreevoteids = new ArrayList();
/*   88 */     this.notagreevoteids.addAll(_o_.notagreevoteids);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   94 */     _xdb_verify_unsafe_();
/*   95 */     _os_.marshal(this.roleid);
/*   96 */     _os_.marshal(this.kickoutid);
/*   97 */     _os_.marshal(this.verifytime);
/*   98 */     _os_.compact_uint32(this.verifyids.size());
/*   99 */     for (Long _v_ : this.verifyids)
/*      */     {
/*  101 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  103 */     _os_.compact_uint32(this.agreevoteids.size());
/*  104 */     for (Long _v_ : this.agreevoteids)
/*      */     {
/*  106 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  108 */     _os_.compact_uint32(this.notagreevoteids.size());
/*  109 */     for (Long _v_ : this.notagreevoteids)
/*      */     {
/*  111 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  113 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  119 */     _xdb_verify_unsafe_();
/*  120 */     this.roleid = _os_.unmarshal_long();
/*  121 */     this.kickoutid = _os_.unmarshal_long();
/*  122 */     this.verifytime = _os_.unmarshal_long();
/*  123 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  125 */       long _v_ = 0L;
/*  126 */       _v_ = _os_.unmarshal_long();
/*  127 */       this.verifyids.add(Long.valueOf(_v_));
/*      */     }
/*  129 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  131 */       long _v_ = 0L;
/*  132 */       _v_ = _os_.unmarshal_long();
/*  133 */       this.agreevoteids.add(Long.valueOf(_v_));
/*      */     }
/*  135 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  137 */       long _v_ = 0L;
/*  138 */       _v_ = _os_.unmarshal_long();
/*  139 */       this.notagreevoteids.add(Long.valueOf(_v_));
/*      */     }
/*  141 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  147 */     _xdb_verify_unsafe_();
/*  148 */     int _size_ = 0;
/*  149 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  150 */     _size_ += CodedOutputStream.computeInt64Size(2, this.kickoutid);
/*  151 */     _size_ += CodedOutputStream.computeInt64Size(3, this.verifytime);
/*  152 */     for (Long _v_ : this.verifyids)
/*      */     {
/*  154 */       _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */     }
/*  156 */     for (Long _v_ : this.agreevoteids)
/*      */     {
/*  158 */       _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */     }
/*  160 */     for (Long _v_ : this.notagreevoteids)
/*      */     {
/*  162 */       _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */     }
/*  164 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  170 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  173 */       _output_.writeInt64(1, this.roleid);
/*  174 */       _output_.writeInt64(2, this.kickoutid);
/*  175 */       _output_.writeInt64(3, this.verifytime);
/*  176 */       for (Long _v_ : this.verifyids)
/*      */       {
/*  178 */         _output_.writeInt64(4, _v_.longValue());
/*      */       }
/*  180 */       for (Long _v_ : this.agreevoteids)
/*      */       {
/*  182 */         _output_.writeInt64(5, _v_.longValue());
/*      */       }
/*  184 */       for (Long _v_ : this.notagreevoteids)
/*      */       {
/*  186 */         _output_.writeInt64(6, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  193 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  199 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  202 */       boolean done = false;
/*  203 */       while (!done)
/*      */       {
/*  205 */         int tag = _input_.readTag();
/*  206 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  210 */           done = true;
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  215 */           this.roleid = _input_.readInt64();
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  220 */           this.kickoutid = _input_.readInt64();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  225 */           this.verifytime = _input_.readInt64();
/*  226 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  230 */           long _v_ = 0L;
/*  231 */           _v_ = _input_.readInt64();
/*  232 */           this.verifyids.add(Long.valueOf(_v_));
/*  233 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  237 */           long _v_ = 0L;
/*  238 */           _v_ = _input_.readInt64();
/*  239 */           this.agreevoteids.add(Long.valueOf(_v_));
/*  240 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  244 */           long _v_ = 0L;
/*  245 */           _v_ = _input_.readInt64();
/*  246 */           this.notagreevoteids.add(Long.valueOf(_v_));
/*  247 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  251 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  253 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  262 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  266 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  268 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornKickOut copy()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new SwornKickOut(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornKickOut toData()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SwornKickOut toBean()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new SwornKickOut(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornKickOut toDataIf()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SwornKickOut toBeanIf()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getKickoutid()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return this.kickoutid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getVerifytime()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return this.verifytime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getVerifyids()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return Logs.logList(new LogKey(this, "verifyids"), this.verifyids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getVerifyidsAsData()
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*      */     
/*  348 */     SwornKickOut _o_ = this;
/*  349 */     List<Long> verifyids = new ArrayList();
/*  350 */     verifyids.addAll(_o_.verifyids);
/*  351 */     return verifyids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getAgreevoteids()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return Logs.logList(new LogKey(this, "agreevoteids"), this.agreevoteids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getAgreevoteidsAsData()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*      */     
/*  367 */     SwornKickOut _o_ = this;
/*  368 */     List<Long> agreevoteids = new ArrayList();
/*  369 */     agreevoteids.addAll(_o_.agreevoteids);
/*  370 */     return agreevoteids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getNotagreevoteids()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return Logs.logList(new LogKey(this, "notagreevoteids"), this.notagreevoteids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getNotagreevoteidsAsData()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*      */     
/*  386 */     SwornKickOut _o_ = this;
/*  387 */     List<Long> notagreevoteids = new ArrayList();
/*  388 */     notagreevoteids.addAll(_o_.notagreevoteids);
/*  389 */     return notagreevoteids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*  397 */     Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  401 */         new LogLong(this, SwornKickOut.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  405 */             SwornKickOut.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  409 */     });
/*  410 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setKickoutid(long _v_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     Logs.logIf(new LogKey(this, "kickoutid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  422 */         new LogLong(this, SwornKickOut.this.kickoutid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  426 */             SwornKickOut.this.kickoutid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  430 */     });
/*  431 */     this.kickoutid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVerifytime(long _v_)
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     Logs.logIf(new LogKey(this, "verifytime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  443 */         new LogLong(this, SwornKickOut.this.verifytime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  447 */             SwornKickOut.this.verifytime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  451 */     });
/*  452 */     this.verifytime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*  459 */     SwornKickOut _o_ = null;
/*  460 */     if ((_o1_ instanceof SwornKickOut)) { _o_ = (SwornKickOut)_o1_;
/*  461 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  462 */       return false;
/*  463 */     if (this.roleid != _o_.roleid) return false;
/*  464 */     if (this.kickoutid != _o_.kickoutid) return false;
/*  465 */     if (this.verifytime != _o_.verifytime) return false;
/*  466 */     if (!this.verifyids.equals(_o_.verifyids)) return false;
/*  467 */     if (!this.agreevoteids.equals(_o_.agreevoteids)) return false;
/*  468 */     if (!this.notagreevoteids.equals(_o_.notagreevoteids)) return false;
/*  469 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*  476 */     int _h_ = 0;
/*  477 */     _h_ = (int)(_h_ + this.roleid);
/*  478 */     _h_ = (int)(_h_ + this.kickoutid);
/*  479 */     _h_ = (int)(_h_ + this.verifytime);
/*  480 */     _h_ += this.verifyids.hashCode();
/*  481 */     _h_ += this.agreevoteids.hashCode();
/*  482 */     _h_ += this.notagreevoteids.hashCode();
/*  483 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  489 */     _xdb_verify_unsafe_();
/*  490 */     StringBuilder _sb_ = new StringBuilder();
/*  491 */     _sb_.append("(");
/*  492 */     _sb_.append(this.roleid);
/*  493 */     _sb_.append(",");
/*  494 */     _sb_.append(this.kickoutid);
/*  495 */     _sb_.append(",");
/*  496 */     _sb_.append(this.verifytime);
/*  497 */     _sb_.append(",");
/*  498 */     _sb_.append(this.verifyids);
/*  499 */     _sb_.append(",");
/*  500 */     _sb_.append(this.agreevoteids);
/*  501 */     _sb_.append(",");
/*  502 */     _sb_.append(this.notagreevoteids);
/*  503 */     _sb_.append(")");
/*  504 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  510 */     ListenableBean lb = new ListenableBean();
/*  511 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  512 */     lb.add(new ListenableChanged().setVarName("kickoutid"));
/*  513 */     lb.add(new ListenableChanged().setVarName("verifytime"));
/*  514 */     lb.add(new ListenableChanged().setVarName("verifyids"));
/*  515 */     lb.add(new ListenableChanged().setVarName("agreevoteids"));
/*  516 */     lb.add(new ListenableChanged().setVarName("notagreevoteids"));
/*  517 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.SwornKickOut {
/*      */     private Const() {}
/*      */     
/*      */     SwornKickOut nThis() {
/*  524 */       return SwornKickOut.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  530 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornKickOut copy()
/*      */     {
/*  536 */       return SwornKickOut.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornKickOut toData()
/*      */     {
/*  542 */       return SwornKickOut.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.SwornKickOut toBean()
/*      */     {
/*  547 */       return SwornKickOut.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornKickOut toDataIf()
/*      */     {
/*  553 */       return SwornKickOut.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.SwornKickOut toBeanIf()
/*      */     {
/*  558 */       return SwornKickOut.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  565 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  566 */       return SwornKickOut.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getKickoutid()
/*      */     {
/*  573 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  574 */       return SwornKickOut.this.kickoutid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getVerifytime()
/*      */     {
/*  581 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  582 */       return SwornKickOut.this.verifytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVerifyids()
/*      */     {
/*  589 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  590 */       return xdb.Consts.constList(SwornKickOut.this.verifyids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getVerifyidsAsData()
/*      */     {
/*  596 */       SwornKickOut.this._xdb_verify_unsafe_();
/*      */       
/*  598 */       SwornKickOut _o_ = SwornKickOut.this;
/*  599 */       List<Long> verifyids = new ArrayList();
/*  600 */       verifyids.addAll(_o_.verifyids);
/*  601 */       return verifyids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAgreevoteids()
/*      */     {
/*  608 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  609 */       return xdb.Consts.constList(SwornKickOut.this.agreevoteids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getAgreevoteidsAsData()
/*      */     {
/*  615 */       SwornKickOut.this._xdb_verify_unsafe_();
/*      */       
/*  617 */       SwornKickOut _o_ = SwornKickOut.this;
/*  618 */       List<Long> agreevoteids = new ArrayList();
/*  619 */       agreevoteids.addAll(_o_.agreevoteids);
/*  620 */       return agreevoteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getNotagreevoteids()
/*      */     {
/*  627 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  628 */       return xdb.Consts.constList(SwornKickOut.this.notagreevoteids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getNotagreevoteidsAsData()
/*      */     {
/*  634 */       SwornKickOut.this._xdb_verify_unsafe_();
/*      */       
/*  636 */       SwornKickOut _o_ = SwornKickOut.this;
/*  637 */       List<Long> notagreevoteids = new ArrayList();
/*  638 */       notagreevoteids.addAll(_o_.notagreevoteids);
/*  639 */       return notagreevoteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  646 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  647 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKickoutid(long _v_)
/*      */     {
/*  654 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  655 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVerifytime(long _v_)
/*      */     {
/*  662 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  663 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  669 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  670 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  676 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  677 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  683 */       return SwornKickOut.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  689 */       return SwornKickOut.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  695 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  696 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  702 */       return SwornKickOut.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  708 */       return SwornKickOut.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  714 */       SwornKickOut.this._xdb_verify_unsafe_();
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  721 */       return SwornKickOut.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  727 */       return SwornKickOut.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  733 */       return SwornKickOut.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  739 */       return SwornKickOut.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  745 */       return SwornKickOut.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  751 */       return SwornKickOut.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  757 */       return SwornKickOut.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.SwornKickOut
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     private long kickoutid;
/*      */     
/*      */     private long verifytime;
/*      */     
/*      */     private ArrayList<Long> verifyids;
/*      */     
/*      */     private ArrayList<Long> agreevoteids;
/*      */     
/*      */     private ArrayList<Long> notagreevoteids;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  779 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  784 */       this.verifytime = 0L;
/*  785 */       this.verifyids = new ArrayList();
/*  786 */       this.agreevoteids = new ArrayList();
/*  787 */       this.notagreevoteids = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.SwornKickOut _o1_)
/*      */     {
/*  792 */       if ((_o1_ instanceof SwornKickOut)) { assign((SwornKickOut)_o1_);
/*  793 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  794 */       } else if ((_o1_ instanceof SwornKickOut.Const)) assign(((SwornKickOut.Const)_o1_).nThis()); else {
/*  795 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(SwornKickOut _o_) {
/*  800 */       this.roleid = _o_.roleid;
/*  801 */       this.kickoutid = _o_.kickoutid;
/*  802 */       this.verifytime = _o_.verifytime;
/*  803 */       this.verifyids = new ArrayList();
/*  804 */       this.verifyids.addAll(_o_.verifyids);
/*  805 */       this.agreevoteids = new ArrayList();
/*  806 */       this.agreevoteids.addAll(_o_.agreevoteids);
/*  807 */       this.notagreevoteids = new ArrayList();
/*  808 */       this.notagreevoteids.addAll(_o_.notagreevoteids);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  813 */       this.roleid = _o_.roleid;
/*  814 */       this.kickoutid = _o_.kickoutid;
/*  815 */       this.verifytime = _o_.verifytime;
/*  816 */       this.verifyids = new ArrayList();
/*  817 */       this.verifyids.addAll(_o_.verifyids);
/*  818 */       this.agreevoteids = new ArrayList();
/*  819 */       this.agreevoteids.addAll(_o_.agreevoteids);
/*  820 */       this.notagreevoteids = new ArrayList();
/*  821 */       this.notagreevoteids.addAll(_o_.notagreevoteids);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  827 */       _os_.marshal(this.roleid);
/*  828 */       _os_.marshal(this.kickoutid);
/*  829 */       _os_.marshal(this.verifytime);
/*  830 */       _os_.compact_uint32(this.verifyids.size());
/*  831 */       for (Long _v_ : this.verifyids)
/*      */       {
/*  833 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  835 */       _os_.compact_uint32(this.agreevoteids.size());
/*  836 */       for (Long _v_ : this.agreevoteids)
/*      */       {
/*  838 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  840 */       _os_.compact_uint32(this.notagreevoteids.size());
/*  841 */       for (Long _v_ : this.notagreevoteids)
/*      */       {
/*  843 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  845 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  851 */       this.roleid = _os_.unmarshal_long();
/*  852 */       this.kickoutid = _os_.unmarshal_long();
/*  853 */       this.verifytime = _os_.unmarshal_long();
/*  854 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  856 */         long _v_ = 0L;
/*  857 */         _v_ = _os_.unmarshal_long();
/*  858 */         this.verifyids.add(Long.valueOf(_v_));
/*      */       }
/*  860 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  862 */         long _v_ = 0L;
/*  863 */         _v_ = _os_.unmarshal_long();
/*  864 */         this.agreevoteids.add(Long.valueOf(_v_));
/*      */       }
/*  866 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  868 */         long _v_ = 0L;
/*  869 */         _v_ = _os_.unmarshal_long();
/*  870 */         this.notagreevoteids.add(Long.valueOf(_v_));
/*      */       }
/*  872 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  878 */       int _size_ = 0;
/*  879 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  880 */       _size_ += CodedOutputStream.computeInt64Size(2, this.kickoutid);
/*  881 */       _size_ += CodedOutputStream.computeInt64Size(3, this.verifytime);
/*  882 */       for (Long _v_ : this.verifyids)
/*      */       {
/*  884 */         _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */       }
/*  886 */       for (Long _v_ : this.agreevoteids)
/*      */       {
/*  888 */         _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */       }
/*  890 */       for (Long _v_ : this.notagreevoteids)
/*      */       {
/*  892 */         _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */       }
/*  894 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  902 */         _output_.writeInt64(1, this.roleid);
/*  903 */         _output_.writeInt64(2, this.kickoutid);
/*  904 */         _output_.writeInt64(3, this.verifytime);
/*  905 */         for (Long _v_ : this.verifyids)
/*      */         {
/*  907 */           _output_.writeInt64(4, _v_.longValue());
/*      */         }
/*  909 */         for (Long _v_ : this.agreevoteids)
/*      */         {
/*  911 */           _output_.writeInt64(5, _v_.longValue());
/*      */         }
/*  913 */         for (Long _v_ : this.notagreevoteids)
/*      */         {
/*  915 */           _output_.writeInt64(6, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  920 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  922 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  930 */         boolean done = false;
/*  931 */         while (!done)
/*      */         {
/*  933 */           int tag = _input_.readTag();
/*  934 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  938 */             done = true;
/*  939 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  943 */             this.roleid = _input_.readInt64();
/*  944 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  948 */             this.kickoutid = _input_.readInt64();
/*  949 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  953 */             this.verifytime = _input_.readInt64();
/*  954 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  958 */             long _v_ = 0L;
/*  959 */             _v_ = _input_.readInt64();
/*  960 */             this.verifyids.add(Long.valueOf(_v_));
/*  961 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  965 */             long _v_ = 0L;
/*  966 */             _v_ = _input_.readInt64();
/*  967 */             this.agreevoteids.add(Long.valueOf(_v_));
/*  968 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  972 */             long _v_ = 0L;
/*  973 */             _v_ = _input_.readInt64();
/*  974 */             this.notagreevoteids.add(Long.valueOf(_v_));
/*  975 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  979 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  981 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  990 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  994 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  996 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornKickOut copy()
/*      */     {
/* 1002 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornKickOut toData()
/*      */     {
/* 1008 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.SwornKickOut toBean()
/*      */     {
/* 1013 */       return new SwornKickOut(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornKickOut toDataIf()
/*      */     {
/* 1019 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.SwornKickOut toBeanIf()
/*      */     {
/* 1024 */       return new SwornKickOut(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1030 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1034 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1038 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1042 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1046 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1050 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1054 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1061 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getKickoutid()
/*      */     {
/* 1068 */       return this.kickoutid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getVerifytime()
/*      */     {
/* 1075 */       return this.verifytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVerifyids()
/*      */     {
/* 1082 */       return this.verifyids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVerifyidsAsData()
/*      */     {
/* 1089 */       return this.verifyids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAgreevoteids()
/*      */     {
/* 1096 */       return this.agreevoteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getAgreevoteidsAsData()
/*      */     {
/* 1103 */       return this.agreevoteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getNotagreevoteids()
/*      */     {
/* 1110 */       return this.notagreevoteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getNotagreevoteidsAsData()
/*      */     {
/* 1117 */       return this.notagreevoteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1124 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKickoutid(long _v_)
/*      */     {
/* 1131 */       this.kickoutid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVerifytime(long _v_)
/*      */     {
/* 1138 */       this.verifytime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1144 */       if (!(_o1_ instanceof Data)) return false;
/* 1145 */       Data _o_ = (Data)_o1_;
/* 1146 */       if (this.roleid != _o_.roleid) return false;
/* 1147 */       if (this.kickoutid != _o_.kickoutid) return false;
/* 1148 */       if (this.verifytime != _o_.verifytime) return false;
/* 1149 */       if (!this.verifyids.equals(_o_.verifyids)) return false;
/* 1150 */       if (!this.agreevoteids.equals(_o_.agreevoteids)) return false;
/* 1151 */       if (!this.notagreevoteids.equals(_o_.notagreevoteids)) return false;
/* 1152 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1158 */       int _h_ = 0;
/* 1159 */       _h_ = (int)(_h_ + this.roleid);
/* 1160 */       _h_ = (int)(_h_ + this.kickoutid);
/* 1161 */       _h_ = (int)(_h_ + this.verifytime);
/* 1162 */       _h_ += this.verifyids.hashCode();
/* 1163 */       _h_ += this.agreevoteids.hashCode();
/* 1164 */       _h_ += this.notagreevoteids.hashCode();
/* 1165 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1171 */       StringBuilder _sb_ = new StringBuilder();
/* 1172 */       _sb_.append("(");
/* 1173 */       _sb_.append(this.roleid);
/* 1174 */       _sb_.append(",");
/* 1175 */       _sb_.append(this.kickoutid);
/* 1176 */       _sb_.append(",");
/* 1177 */       _sb_.append(this.verifytime);
/* 1178 */       _sb_.append(",");
/* 1179 */       _sb_.append(this.verifyids);
/* 1180 */       _sb_.append(",");
/* 1181 */       _sb_.append(this.agreevoteids);
/* 1182 */       _sb_.append(",");
/* 1183 */       _sb_.append(this.notagreevoteids);
/* 1184 */       _sb_.append(")");
/* 1185 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SwornKickOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */