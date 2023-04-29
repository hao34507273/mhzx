/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class Invitation extends XBean implements xbean.Invitation
/*      */ {
/*      */   private long roleid;
/*      */   private int gifttype;
/*      */   private LinkedList<String> msgargs;
/*      */   private HashMap<Long, xbean.InvitedRole> invitedmap;
/*      */   private long invitationtime;
/*      */   private SetX<Long> knowninvitedroles;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.roleid = 0L;
/*   29 */     this.gifttype = 0;
/*   30 */     this.msgargs.clear();
/*   31 */     this.invitedmap.clear();
/*   32 */     this.invitationtime = 0L;
/*   33 */     this.knowninvitedroles.clear();
/*      */   }
/*      */   
/*      */   Invitation(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.msgargs = new LinkedList();
/*   40 */     this.invitedmap = new HashMap();
/*   41 */     this.knowninvitedroles = new SetX();
/*      */   }
/*      */   
/*      */   public Invitation()
/*      */   {
/*   46 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Invitation(Invitation _o_)
/*      */   {
/*   51 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Invitation(xbean.Invitation _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     if ((_o1_ instanceof Invitation)) { assign((Invitation)_o1_);
/*   58 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   59 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   60 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Invitation _o_) {
/*   65 */     _o_._xdb_verify_unsafe_();
/*   66 */     this.roleid = _o_.roleid;
/*   67 */     this.gifttype = _o_.gifttype;
/*   68 */     this.msgargs = new LinkedList();
/*   69 */     this.msgargs.addAll(_o_.msgargs);
/*   70 */     this.invitedmap = new HashMap();
/*   71 */     for (Map.Entry<Long, xbean.InvitedRole> _e_ : _o_.invitedmap.entrySet())
/*   72 */       this.invitedmap.put(_e_.getKey(), new InvitedRole((xbean.InvitedRole)_e_.getValue(), this, "invitedmap"));
/*   73 */     this.invitationtime = _o_.invitationtime;
/*   74 */     this.knowninvitedroles = new SetX();
/*   75 */     this.knowninvitedroles.addAll(_o_.knowninvitedroles);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   80 */     this.roleid = _o_.roleid;
/*   81 */     this.gifttype = _o_.gifttype;
/*   82 */     this.msgargs = new LinkedList();
/*   83 */     this.msgargs.addAll(_o_.msgargs);
/*   84 */     this.invitedmap = new HashMap();
/*   85 */     for (Map.Entry<Long, xbean.InvitedRole> _e_ : _o_.invitedmap.entrySet())
/*   86 */       this.invitedmap.put(_e_.getKey(), new InvitedRole((xbean.InvitedRole)_e_.getValue(), this, "invitedmap"));
/*   87 */     this.invitationtime = _o_.invitationtime;
/*   88 */     this.knowninvitedroles = new SetX();
/*   89 */     this.knowninvitedroles.addAll(_o_.knowninvitedroles);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   95 */     _xdb_verify_unsafe_();
/*   96 */     _os_.marshal(this.roleid);
/*   97 */     _os_.marshal(this.gifttype);
/*   98 */     _os_.compact_uint32(this.msgargs.size());
/*   99 */     for (String _v_ : this.msgargs)
/*      */     {
/*  101 */       _os_.marshal(_v_, "UTF-16LE");
/*      */     }
/*  103 */     _os_.compact_uint32(this.invitedmap.size());
/*  104 */     for (Map.Entry<Long, xbean.InvitedRole> _e_ : this.invitedmap.entrySet())
/*      */     {
/*  106 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  107 */       ((xbean.InvitedRole)_e_.getValue()).marshal(_os_);
/*      */     }
/*  109 */     _os_.marshal(this.invitationtime);
/*  110 */     _os_.compact_uint32(this.knowninvitedroles.size());
/*  111 */     for (Long _v_ : this.knowninvitedroles)
/*      */     {
/*  113 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  115 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  121 */     _xdb_verify_unsafe_();
/*  122 */     this.roleid = _os_.unmarshal_long();
/*  123 */     this.gifttype = _os_.unmarshal_int();
/*  124 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  126 */       String _v_ = "";
/*  127 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  128 */       this.msgargs.add(_v_);
/*      */     }
/*      */     
/*  131 */     int size = _os_.uncompact_uint32();
/*  132 */     if (size >= 12)
/*      */     {
/*  134 */       this.invitedmap = new HashMap(size * 2);
/*      */     }
/*  136 */     for (; size > 0; size--)
/*      */     {
/*  138 */       long _k_ = 0L;
/*  139 */       _k_ = _os_.unmarshal_long();
/*  140 */       xbean.InvitedRole _v_ = new InvitedRole(0, this, "invitedmap");
/*  141 */       _v_.unmarshal(_os_);
/*  142 */       this.invitedmap.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  145 */     this.invitationtime = _os_.unmarshal_long();
/*  146 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  148 */       long _v_ = 0L;
/*  149 */       _v_ = _os_.unmarshal_long();
/*  150 */       this.knowninvitedroles.add(Long.valueOf(_v_));
/*      */     }
/*  152 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  158 */     _xdb_verify_unsafe_();
/*  159 */     int _size_ = 0;
/*  160 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  161 */     _size_ += CodedOutputStream.computeInt32Size(2, this.gifttype);
/*  162 */     for (String _v_ : this.msgargs)
/*      */     {
/*      */       try
/*      */       {
/*  166 */         _size_ += CodedOutputStream.computeBytesSize(4, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  170 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  173 */     for (Map.Entry<Long, xbean.InvitedRole> _e_ : this.invitedmap.entrySet())
/*      */     {
/*  175 */       _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  176 */       _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */     }
/*  178 */     _size_ += CodedOutputStream.computeInt64Size(6, this.invitationtime);
/*  179 */     for (Long _v_ : this.knowninvitedroles)
/*      */     {
/*  181 */       _size_ += CodedOutputStream.computeInt64Size(7, _v_.longValue());
/*      */     }
/*  183 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  189 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  192 */       _output_.writeInt64(1, this.roleid);
/*  193 */       _output_.writeInt32(2, this.gifttype);
/*  194 */       for (String _v_ : this.msgargs)
/*      */       {
/*  196 */         _output_.writeBytes(4, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */       }
/*  198 */       for (Map.Entry<Long, xbean.InvitedRole> _e_ : this.invitedmap.entrySet())
/*      */       {
/*  200 */         _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  201 */         _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*  203 */       _output_.writeInt64(6, this.invitationtime);
/*  204 */       for (Long _v_ : this.knowninvitedroles)
/*      */       {
/*  206 */         _output_.writeInt64(7, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  211 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  213 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  219 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  222 */       boolean done = false;
/*  223 */       while (!done)
/*      */       {
/*  225 */         int tag = _input_.readTag();
/*  226 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  230 */           done = true;
/*  231 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  235 */           this.roleid = _input_.readInt64();
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  240 */           this.gifttype = _input_.readInt32();
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  245 */           String _v_ = "";
/*  246 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  247 */           this.msgargs.add(_v_);
/*  248 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  252 */           long _k_ = 0L;
/*  253 */           _k_ = _input_.readInt64();
/*  254 */           int readTag = _input_.readTag();
/*  255 */           if (42 != readTag)
/*      */           {
/*  257 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  259 */           xbean.InvitedRole _v_ = new InvitedRole(0, this, "invitedmap");
/*  260 */           _input_.readMessage(_v_);
/*  261 */           this.invitedmap.put(Long.valueOf(_k_), _v_);
/*  262 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  266 */           this.invitationtime = _input_.readInt64();
/*  267 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  271 */           long _v_ = 0L;
/*  272 */           _v_ = _input_.readInt64();
/*  273 */           this.knowninvitedroles.add(Long.valueOf(_v_));
/*  274 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  278 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  280 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  289 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  293 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  295 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Invitation copy()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return new Invitation(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Invitation toData()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Invitation toBean()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return new Invitation(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Invitation toDataIf()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Invitation toBeanIf()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGifttype()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return this.gifttype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<String> getMsgargs()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return xdb.Logs.logList(new LogKey(this, "msgargs"), this.msgargs);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<String> getMsgargsAsData()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*      */     
/*  367 */     Invitation _o_ = this;
/*  368 */     List<String> msgargs = new LinkedList();
/*  369 */     msgargs.addAll(_o_.msgargs);
/*  370 */     return msgargs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.InvitedRole> getInvitedmap()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return xdb.Logs.logMap(new LogKey(this, "invitedmap"), this.invitedmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.InvitedRole> getInvitedmapAsData()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*      */     
/*  387 */     Invitation _o_ = this;
/*  388 */     Map<Long, xbean.InvitedRole> invitedmap = new HashMap();
/*  389 */     for (Map.Entry<Long, xbean.InvitedRole> _e_ : _o_.invitedmap.entrySet())
/*  390 */       invitedmap.put(_e_.getKey(), new InvitedRole.Data((xbean.InvitedRole)_e_.getValue()));
/*  391 */     return invitedmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInvitationtime()
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     return this.invitationtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public java.util.Set<Long> getKnowninvitedroles()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return xdb.Logs.logSet(new LogKey(this, "knowninvitedroles"), this.knowninvitedroles);
/*      */   }
/*      */   
/*      */ 
/*      */   public java.util.Set<Long> getKnowninvitedrolesAsData()
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*      */     
/*  415 */     Invitation _o_ = this;
/*  416 */     java.util.Set<Long> knowninvitedroles = new SetX();
/*  417 */     knowninvitedroles.addAll(_o_.knowninvitedroles);
/*  418 */     return knowninvitedroles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  430 */         new xdb.logs.LogLong(this, Invitation.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  434 */             Invitation.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  438 */     });
/*  439 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGifttype(int _v_)
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     xdb.Logs.logIf(new LogKey(this, "gifttype")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  451 */         new xdb.logs.LogInt(this, Invitation.this.gifttype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  455 */             Invitation.this.gifttype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  459 */     });
/*  460 */     this.gifttype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInvitationtime(long _v_)
/*      */   {
/*  467 */     _xdb_verify_unsafe_();
/*  468 */     xdb.Logs.logIf(new LogKey(this, "invitationtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  472 */         new xdb.logs.LogLong(this, Invitation.this.invitationtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  476 */             Invitation.this.invitationtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  480 */     });
/*  481 */     this.invitationtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  487 */     _xdb_verify_unsafe_();
/*  488 */     Invitation _o_ = null;
/*  489 */     if ((_o1_ instanceof Invitation)) { _o_ = (Invitation)_o1_;
/*  490 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  491 */       return false;
/*  492 */     if (this.roleid != _o_.roleid) return false;
/*  493 */     if (this.gifttype != _o_.gifttype) return false;
/*  494 */     if (!this.msgargs.equals(_o_.msgargs)) return false;
/*  495 */     if (!this.invitedmap.equals(_o_.invitedmap)) return false;
/*  496 */     if (this.invitationtime != _o_.invitationtime) return false;
/*  497 */     if (!this.knowninvitedroles.equals(_o_.knowninvitedroles)) return false;
/*  498 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  504 */     _xdb_verify_unsafe_();
/*  505 */     int _h_ = 0;
/*  506 */     _h_ = (int)(_h_ + this.roleid);
/*  507 */     _h_ += this.gifttype;
/*  508 */     _h_ += this.msgargs.hashCode();
/*  509 */     _h_ += this.invitedmap.hashCode();
/*  510 */     _h_ = (int)(_h_ + this.invitationtime);
/*  511 */     _h_ += this.knowninvitedroles.hashCode();
/*  512 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  518 */     _xdb_verify_unsafe_();
/*  519 */     StringBuilder _sb_ = new StringBuilder();
/*  520 */     _sb_.append("(");
/*  521 */     _sb_.append(this.roleid);
/*  522 */     _sb_.append(",");
/*  523 */     _sb_.append(this.gifttype);
/*  524 */     _sb_.append(",");
/*  525 */     _sb_.append(this.msgargs);
/*  526 */     _sb_.append(",");
/*  527 */     _sb_.append(this.invitedmap);
/*  528 */     _sb_.append(",");
/*  529 */     _sb_.append(this.invitationtime);
/*  530 */     _sb_.append(",");
/*  531 */     _sb_.append(this.knowninvitedroles);
/*  532 */     _sb_.append(")");
/*  533 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  539 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  540 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roleid"));
/*  541 */     lb.add(new xdb.logs.ListenableChanged().setVarName("gifttype"));
/*  542 */     lb.add(new xdb.logs.ListenableChanged().setVarName("msgargs"));
/*  543 */     lb.add(new xdb.logs.ListenableMap().setVarName("invitedmap"));
/*  544 */     lb.add(new xdb.logs.ListenableChanged().setVarName("invitationtime"));
/*  545 */     lb.add(new xdb.logs.ListenableSet().setVarName("knowninvitedroles"));
/*  546 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Invitation {
/*      */     private Const() {}
/*      */     
/*      */     Invitation nThis() {
/*  553 */       return Invitation.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  559 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Invitation copy()
/*      */     {
/*  565 */       return Invitation.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Invitation toData()
/*      */     {
/*  571 */       return Invitation.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Invitation toBean()
/*      */     {
/*  576 */       return Invitation.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Invitation toDataIf()
/*      */     {
/*  582 */       return Invitation.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Invitation toBeanIf()
/*      */     {
/*  587 */       return Invitation.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  594 */       Invitation.this._xdb_verify_unsafe_();
/*  595 */       return Invitation.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGifttype()
/*      */     {
/*  602 */       Invitation.this._xdb_verify_unsafe_();
/*  603 */       return Invitation.this.gifttype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<String> getMsgargs()
/*      */     {
/*  610 */       Invitation.this._xdb_verify_unsafe_();
/*  611 */       return xdb.Consts.constList(Invitation.this.msgargs);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<String> getMsgargsAsData()
/*      */     {
/*  617 */       Invitation.this._xdb_verify_unsafe_();
/*      */       
/*  619 */       Invitation _o_ = Invitation.this;
/*  620 */       List<String> msgargs = new LinkedList();
/*  621 */       msgargs.addAll(_o_.msgargs);
/*  622 */       return msgargs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.InvitedRole> getInvitedmap()
/*      */     {
/*  629 */       Invitation.this._xdb_verify_unsafe_();
/*  630 */       return xdb.Consts.constMap(Invitation.this.invitedmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.InvitedRole> getInvitedmapAsData()
/*      */     {
/*  637 */       Invitation.this._xdb_verify_unsafe_();
/*      */       
/*  639 */       Invitation _o_ = Invitation.this;
/*  640 */       Map<Long, xbean.InvitedRole> invitedmap = new HashMap();
/*  641 */       for (Map.Entry<Long, xbean.InvitedRole> _e_ : _o_.invitedmap.entrySet())
/*  642 */         invitedmap.put(_e_.getKey(), new InvitedRole.Data((xbean.InvitedRole)_e_.getValue()));
/*  643 */       return invitedmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitationtime()
/*      */     {
/*  650 */       Invitation.this._xdb_verify_unsafe_();
/*  651 */       return Invitation.this.invitationtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Set<Long> getKnowninvitedroles()
/*      */     {
/*  658 */       Invitation.this._xdb_verify_unsafe_();
/*  659 */       return xdb.Consts.constSet(Invitation.this.knowninvitedroles);
/*      */     }
/*      */     
/*      */ 
/*      */     public java.util.Set<Long> getKnowninvitedrolesAsData()
/*      */     {
/*  665 */       Invitation.this._xdb_verify_unsafe_();
/*      */       
/*  667 */       Invitation _o_ = Invitation.this;
/*  668 */       java.util.Set<Long> knowninvitedroles = new SetX();
/*  669 */       knowninvitedroles.addAll(_o_.knowninvitedroles);
/*  670 */       return knowninvitedroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  677 */       Invitation.this._xdb_verify_unsafe_();
/*  678 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGifttype(int _v_)
/*      */     {
/*  685 */       Invitation.this._xdb_verify_unsafe_();
/*  686 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitationtime(long _v_)
/*      */     {
/*  693 */       Invitation.this._xdb_verify_unsafe_();
/*  694 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  700 */       Invitation.this._xdb_verify_unsafe_();
/*  701 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  707 */       Invitation.this._xdb_verify_unsafe_();
/*  708 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  714 */       return Invitation.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  720 */       return Invitation.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  726 */       Invitation.this._xdb_verify_unsafe_();
/*  727 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  733 */       return Invitation.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  739 */       return Invitation.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  745 */       Invitation.this._xdb_verify_unsafe_();
/*  746 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  752 */       return Invitation.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  758 */       return Invitation.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  764 */       return Invitation.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  770 */       return Invitation.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  776 */       return Invitation.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  782 */       return Invitation.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  788 */       return Invitation.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Invitation
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     private int gifttype;
/*      */     
/*      */     private LinkedList<String> msgargs;
/*      */     
/*      */     private HashMap<Long, xbean.InvitedRole> invitedmap;
/*      */     
/*      */     private long invitationtime;
/*      */     
/*      */     private HashSet<Long> knowninvitedroles;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  810 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  815 */       this.msgargs = new LinkedList();
/*  816 */       this.invitedmap = new HashMap();
/*  817 */       this.knowninvitedroles = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.Invitation _o1_)
/*      */     {
/*  822 */       if ((_o1_ instanceof Invitation)) { assign((Invitation)_o1_);
/*  823 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  824 */       } else if ((_o1_ instanceof Invitation.Const)) assign(((Invitation.Const)_o1_).nThis()); else {
/*  825 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Invitation _o_) {
/*  830 */       this.roleid = _o_.roleid;
/*  831 */       this.gifttype = _o_.gifttype;
/*  832 */       this.msgargs = new LinkedList();
/*  833 */       this.msgargs.addAll(_o_.msgargs);
/*  834 */       this.invitedmap = new HashMap();
/*  835 */       for (Map.Entry<Long, xbean.InvitedRole> _e_ : _o_.invitedmap.entrySet())
/*  836 */         this.invitedmap.put(_e_.getKey(), new InvitedRole.Data((xbean.InvitedRole)_e_.getValue()));
/*  837 */       this.invitationtime = _o_.invitationtime;
/*  838 */       this.knowninvitedroles = new HashSet();
/*  839 */       this.knowninvitedroles.addAll(_o_.knowninvitedroles);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  844 */       this.roleid = _o_.roleid;
/*  845 */       this.gifttype = _o_.gifttype;
/*  846 */       this.msgargs = new LinkedList();
/*  847 */       this.msgargs.addAll(_o_.msgargs);
/*  848 */       this.invitedmap = new HashMap();
/*  849 */       for (Map.Entry<Long, xbean.InvitedRole> _e_ : _o_.invitedmap.entrySet())
/*  850 */         this.invitedmap.put(_e_.getKey(), new InvitedRole.Data((xbean.InvitedRole)_e_.getValue()));
/*  851 */       this.invitationtime = _o_.invitationtime;
/*  852 */       this.knowninvitedroles = new HashSet();
/*  853 */       this.knowninvitedroles.addAll(_o_.knowninvitedroles);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  859 */       _os_.marshal(this.roleid);
/*  860 */       _os_.marshal(this.gifttype);
/*  861 */       _os_.compact_uint32(this.msgargs.size());
/*  862 */       for (String _v_ : this.msgargs)
/*      */       {
/*  864 */         _os_.marshal(_v_, "UTF-16LE");
/*      */       }
/*  866 */       _os_.compact_uint32(this.invitedmap.size());
/*  867 */       for (Map.Entry<Long, xbean.InvitedRole> _e_ : this.invitedmap.entrySet())
/*      */       {
/*  869 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  870 */         ((xbean.InvitedRole)_e_.getValue()).marshal(_os_);
/*      */       }
/*  872 */       _os_.marshal(this.invitationtime);
/*  873 */       _os_.compact_uint32(this.knowninvitedroles.size());
/*  874 */       for (Long _v_ : this.knowninvitedroles)
/*      */       {
/*  876 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  878 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  884 */       this.roleid = _os_.unmarshal_long();
/*  885 */       this.gifttype = _os_.unmarshal_int();
/*  886 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  888 */         String _v_ = "";
/*  889 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/*  890 */         this.msgargs.add(_v_);
/*      */       }
/*      */       
/*  893 */       int size = _os_.uncompact_uint32();
/*  894 */       if (size >= 12)
/*      */       {
/*  896 */         this.invitedmap = new HashMap(size * 2);
/*      */       }
/*  898 */       for (; size > 0; size--)
/*      */       {
/*  900 */         long _k_ = 0L;
/*  901 */         _k_ = _os_.unmarshal_long();
/*  902 */         xbean.InvitedRole _v_ = xbean.Pod.newInvitedRoleData();
/*  903 */         _v_.unmarshal(_os_);
/*  904 */         this.invitedmap.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  907 */       this.invitationtime = _os_.unmarshal_long();
/*  908 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  910 */         long _v_ = 0L;
/*  911 */         _v_ = _os_.unmarshal_long();
/*  912 */         this.knowninvitedroles.add(Long.valueOf(_v_));
/*      */       }
/*  914 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  920 */       int _size_ = 0;
/*  921 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  922 */       _size_ += CodedOutputStream.computeInt32Size(2, this.gifttype);
/*  923 */       for (String _v_ : this.msgargs)
/*      */       {
/*      */         try
/*      */         {
/*  927 */           _size_ += CodedOutputStream.computeBytesSize(4, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */         }
/*      */         catch (java.io.UnsupportedEncodingException e)
/*      */         {
/*  931 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/*  934 */       for (Map.Entry<Long, xbean.InvitedRole> _e_ : this.invitedmap.entrySet())
/*      */       {
/*  936 */         _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  937 */         _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*  939 */       _size_ += CodedOutputStream.computeInt64Size(6, this.invitationtime);
/*  940 */       for (Long _v_ : this.knowninvitedroles)
/*      */       {
/*  942 */         _size_ += CodedOutputStream.computeInt64Size(7, _v_.longValue());
/*      */       }
/*  944 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  952 */         _output_.writeInt64(1, this.roleid);
/*  953 */         _output_.writeInt32(2, this.gifttype);
/*  954 */         for (String _v_ : this.msgargs)
/*      */         {
/*  956 */           _output_.writeBytes(4, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */         }
/*  958 */         for (Map.Entry<Long, xbean.InvitedRole> _e_ : this.invitedmap.entrySet())
/*      */         {
/*  960 */           _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  961 */           _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */         }
/*  963 */         _output_.writeInt64(6, this.invitationtime);
/*  964 */         for (Long _v_ : this.knowninvitedroles)
/*      */         {
/*  966 */           _output_.writeInt64(7, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  971 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  973 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  981 */         boolean done = false;
/*  982 */         while (!done)
/*      */         {
/*  984 */           int tag = _input_.readTag();
/*  985 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  989 */             done = true;
/*  990 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  994 */             this.roleid = _input_.readInt64();
/*  995 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  999 */             this.gifttype = _input_.readInt32();
/* 1000 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/* 1004 */             String _v_ = "";
/* 1005 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 1006 */             this.msgargs.add(_v_);
/* 1007 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1011 */             long _k_ = 0L;
/* 1012 */             _k_ = _input_.readInt64();
/* 1013 */             int readTag = _input_.readTag();
/* 1014 */             if (42 != readTag)
/*      */             {
/* 1016 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1018 */             xbean.InvitedRole _v_ = xbean.Pod.newInvitedRoleData();
/* 1019 */             _input_.readMessage(_v_);
/* 1020 */             this.invitedmap.put(Long.valueOf(_k_), _v_);
/* 1021 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1025 */             this.invitationtime = _input_.readInt64();
/* 1026 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1030 */             long _v_ = 0L;
/* 1031 */             _v_ = _input_.readInt64();
/* 1032 */             this.knowninvitedroles.add(Long.valueOf(_v_));
/* 1033 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1037 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1039 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1048 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1052 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1054 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Invitation copy()
/*      */     {
/* 1060 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Invitation toData()
/*      */     {
/* 1066 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Invitation toBean()
/*      */     {
/* 1071 */       return new Invitation(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Invitation toDataIf()
/*      */     {
/* 1077 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Invitation toBeanIf()
/*      */     {
/* 1082 */       return new Invitation(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1088 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1092 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1096 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1100 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1104 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1108 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1112 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1119 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGifttype()
/*      */     {
/* 1126 */       return this.gifttype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<String> getMsgargs()
/*      */     {
/* 1133 */       return this.msgargs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<String> getMsgargsAsData()
/*      */     {
/* 1140 */       return this.msgargs;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.InvitedRole> getInvitedmap()
/*      */     {
/* 1147 */       return this.invitedmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.InvitedRole> getInvitedmapAsData()
/*      */     {
/* 1154 */       return this.invitedmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitationtime()
/*      */     {
/* 1161 */       return this.invitationtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Set<Long> getKnowninvitedroles()
/*      */     {
/* 1168 */       return this.knowninvitedroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Set<Long> getKnowninvitedrolesAsData()
/*      */     {
/* 1175 */       return this.knowninvitedroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1182 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGifttype(int _v_)
/*      */     {
/* 1189 */       this.gifttype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitationtime(long _v_)
/*      */     {
/* 1196 */       this.invitationtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1202 */       if (!(_o1_ instanceof Data)) return false;
/* 1203 */       Data _o_ = (Data)_o1_;
/* 1204 */       if (this.roleid != _o_.roleid) return false;
/* 1205 */       if (this.gifttype != _o_.gifttype) return false;
/* 1206 */       if (!this.msgargs.equals(_o_.msgargs)) return false;
/* 1207 */       if (!this.invitedmap.equals(_o_.invitedmap)) return false;
/* 1208 */       if (this.invitationtime != _o_.invitationtime) return false;
/* 1209 */       if (!this.knowninvitedroles.equals(_o_.knowninvitedroles)) return false;
/* 1210 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1216 */       int _h_ = 0;
/* 1217 */       _h_ = (int)(_h_ + this.roleid);
/* 1218 */       _h_ += this.gifttype;
/* 1219 */       _h_ += this.msgargs.hashCode();
/* 1220 */       _h_ += this.invitedmap.hashCode();
/* 1221 */       _h_ = (int)(_h_ + this.invitationtime);
/* 1222 */       _h_ += this.knowninvitedroles.hashCode();
/* 1223 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1229 */       StringBuilder _sb_ = new StringBuilder();
/* 1230 */       _sb_.append("(");
/* 1231 */       _sb_.append(this.roleid);
/* 1232 */       _sb_.append(",");
/* 1233 */       _sb_.append(this.gifttype);
/* 1234 */       _sb_.append(",");
/* 1235 */       _sb_.append(this.msgargs);
/* 1236 */       _sb_.append(",");
/* 1237 */       _sb_.append(this.invitedmap);
/* 1238 */       _sb_.append(",");
/* 1239 */       _sb_.append(this.invitationtime);
/* 1240 */       _sb_.append(",");
/* 1241 */       _sb_.append(this.knowninvitedroles);
/* 1242 */       _sb_.append(")");
/* 1243 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Invitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */